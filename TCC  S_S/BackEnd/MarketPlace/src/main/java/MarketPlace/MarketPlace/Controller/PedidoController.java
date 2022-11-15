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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import MarketPlace.MarketPlace.Controller.DTO.PedidoDTO;
import MarketPlace.MarketPlace.Controller.Form.PedidoForm;
import MarketPlace.MarketPlace.Modelo.Pedido;
import MarketPlace.MarketPlace.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@CrossOrigin
	@GetMapping
	public List<Pedido> listarPedido(long idPedido) {

		if (idPedido == 0) {
			List<Pedido> pedidos = pedidoRepository.findAll();
			return pedidos;

		} else {
			List<Pedido> pedidos = pedidoRepository.findByIdPedido(idPedido);
			return pedidos;
		}
	}

	@CrossOrigin
	@GetMapping("/{idPedido}")
	public ResponseEntity<PedidoDTO> buscarPedido(@PathVariable long idPedido) {

		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(new PedidoDTO(pedido.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<PedidoDTO> cadastrarPedido(@RequestBody @Valid PedidoForm pedidoForm,
			UriComponentsBuilder uriBuilder) {
		Pedido pedido = pedidoForm.converter();
		pedidoRepository.save(pedido);

		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getIdPedido()).toUri();

		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
	}

	@CrossOrigin
	@DeleteMapping("/{idUsuario}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable long idPedido) {
		pedidoRepository.deleteById(idPedido);
		return ResponseEntity.ok().build();
	}
}
