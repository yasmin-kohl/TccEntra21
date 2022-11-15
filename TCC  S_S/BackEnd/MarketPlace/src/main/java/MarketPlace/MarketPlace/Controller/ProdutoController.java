package MarketPlace.MarketPlace.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import MarketPlace.MarketPlace.Controller.DTO.ProdutoDTO;
import MarketPlace.MarketPlace.Controller.Form.AtualizacaoProdutoForm;
import MarketPlace.MarketPlace.Controller.Form.ProdutoForm;
import MarketPlace.MarketPlace.Modelo.Produto;
import MarketPlace.MarketPlace.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@CrossOrigin
	@GetMapping
	public List<Produto> listarProduto(long idProduto) {

		if (idProduto == 0) {
			List<Produto> produtos = produtoRepository.findAll();
			return produtos;

		} else {
			List<Produto> produtos = produtoRepository.findByIdProduto(idProduto);
			return produtos;
		}
	}

	@CrossOrigin
	@GetMapping("/{idProduto}")
	public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable long idProduto) {

		Optional<Produto> produto = produtoRepository.findById(idProduto);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(produto.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody @Valid ProdutoForm produtoForm,
			UriComponentsBuilder uriBuilder) {
		Produto produto = produtoForm.converter();
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getIdProduto()).toUri();

		return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}

	@CrossOrigin
	@PutMapping("/{idProduto}")
	@Transactional
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable long idProduto,
			@RequestBody @Valid AtualizacaoProdutoForm produtoForm) {
		Produto produto = produtoForm.atualizar(idProduto, produtoRepository);

		return ResponseEntity.ok(new ProdutoDTO(produto));
	}

	@CrossOrigin
	@DeleteMapping("/{idProduto}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable long idProduto) {
		produtoRepository.deleteById(idProduto);
		return ResponseEntity.ok().build();
	}

}
