package MarketPlace.MarketPlace.Controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import MarketPlace.MarketPlace.Controller.DTO.EnderecoDTO;
import MarketPlace.MarketPlace.Controller.Form.EnderecoForm;
import MarketPlace.MarketPlace.Modelo.Endereco;
import MarketPlace.MarketPlace.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody @Valid EnderecoForm enderecoForm,
			UriComponentsBuilder uriBuilder) {
		
		Endereco endereco = enderecoForm.converter();
		enderecoRepository.save(endereco);

		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getIdEndereco()).toUri();

		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}
}
