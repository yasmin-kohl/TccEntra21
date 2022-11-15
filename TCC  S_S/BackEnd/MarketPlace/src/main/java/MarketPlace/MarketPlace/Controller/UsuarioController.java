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
import MarketPlace.MarketPlace.Controller.DTO.UsuarioDTO;
import MarketPlace.MarketPlace.Controller.Form.AtualizacaoUsuarioForm;
import MarketPlace.MarketPlace.Controller.Form.UsuarioForm;
import MarketPlace.MarketPlace.Modelo.Usuario;
import MarketPlace.MarketPlace.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@CrossOrigin
	@GetMapping
	public List<Usuario> listarUsuario(long idUsuario) {

		if (idUsuario == 0) {
			List<Usuario> usuarios = usuarioRepository.findAll();
			return usuarios;

		} else {
			List<Usuario> usuarios = usuarioRepository.findByIdUsuario(idUsuario);
			return usuarios;
		}
	}

	@CrossOrigin
	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable long idUsuario) {

		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDTO(usuario.get()));
		}

		return ResponseEntity.notFound().build();

	}

	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();

		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
	}

	@CrossOrigin
	@PutMapping("/{idUsuario}")
	@Transactional
	public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable long idUsuario,
			@RequestBody @Valid AtualizacaoUsuarioForm usuarioForm) {
		Usuario usuario = usuarioForm.atualizar(idUsuario, usuarioRepository);

		return ResponseEntity.ok(new UsuarioDTO(usuario));
	}

	@CrossOrigin
	@DeleteMapping("/{idUsuario}")
	@Transactional
	public ResponseEntity<?> removerUsuario(@PathVariable long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
		return ResponseEntity.ok().build();
	}

	@CrossOrigin
	@GetMapping("/logar")
	public ResponseEntity<UsuarioDTO> loginUsuario(String email, String senha) {
		List<Usuario> usuarios = usuarioRepository.findByEmail(email);
		if (!usuarios.isEmpty()) {
			Usuario usuario = usuarios.get(0);
			if (usuario.getSenha().equals(senha)) {
				return ResponseEntity.ok(new UsuarioDTO(usuario));
			}
		}

		return ResponseEntity.notFound().build();

	}

}
