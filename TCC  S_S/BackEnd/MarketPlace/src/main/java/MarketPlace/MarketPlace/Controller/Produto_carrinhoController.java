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

import MarketPlace.MarketPlace.Controller.DTO.Produto_carrinhoDTO;
import MarketPlace.MarketPlace.Controller.Form.AtualizacaoProduto_carrinhoForm;
import MarketPlace.MarketPlace.Controller.Form.Produto_carrinhoForm;
import MarketPlace.MarketPlace.Modelo.Produto_carrinho;
import MarketPlace.MarketPlace.repository.Produto_carrinhoRepository;

@RestController
@RequestMapping("/Produto_carrinho")
public class Produto_carrinhoController {

	@Autowired
	private Produto_carrinhoRepository produto_carrinhoRepository;

	@CrossOrigin
	@GetMapping
	public List<Produto_carrinho> listarProduto_carrinho(long idProdutoCarrinho) {

		if (idProdutoCarrinho == 0) {
			List<Produto_carrinho> produtos_carrinho = produto_carrinhoRepository.findAll();
			return produtos_carrinho;

		} else {
			List<Produto_carrinho> produtos_carrinho = produto_carrinhoRepository
					.findByIdProdutoCarrinho(idProdutoCarrinho);
			return produtos_carrinho;
		}
	}

	@CrossOrigin
	@GetMapping("/{idProduto_carrinho}")
	public ResponseEntity<Produto_carrinhoDTO> buscarProduto_carrinho(@PathVariable long idProdutoCarrinho) {

		Optional<Produto_carrinho> produto_carrinho = produto_carrinhoRepository.findById(idProdutoCarrinho);
		if (produto_carrinho.isPresent()) {
			return ResponseEntity.ok(new Produto_carrinhoDTO(produto_carrinho.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<Produto_carrinhoDTO> cadastrarProduto_carrinho(
			@RequestBody @Valid Produto_carrinhoForm produto_carrinhoForm, UriComponentsBuilder uriBuilder) {
		Produto_carrinho produto_carrinho = produto_carrinhoForm.converter();
		produto_carrinhoRepository.save(produto_carrinho);

		URI uri = uriBuilder.path("/produto_carrinho/{id}").buildAndExpand(produto_carrinho.getIdProdutoCarrinho())
				.toUri();

		return ResponseEntity.created(uri).body(new Produto_carrinhoDTO(produto_carrinho));
	}

	@CrossOrigin
	@PutMapping("/{idProduto_carrinho}")
	@Transactional
	public ResponseEntity<Produto_carrinhoDTO> atualizar(@PathVariable long idProdutoCarrinho,
			@RequestBody @Valid AtualizacaoProduto_carrinhoForm produto_carrinhoForm) {
		Produto_carrinho produto_carrinho = produto_carrinhoForm.atualizar(idProdutoCarrinho,
				produto_carrinhoRepository);

		return ResponseEntity.ok(new Produto_carrinhoDTO(produto_carrinho));
	}

	@CrossOrigin
	@DeleteMapping("/{idaparoduto_carrinho}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable long idProdutoCarrinho) {
		produto_carrinhoRepository.deleteById(idProdutoCarrinho);
		return ResponseEntity.ok().build();
	}

}
