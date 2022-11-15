package MarketPlace.MarketPlace.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import MarketPlace.MarketPlace.Modelo.Pedido;

public class PedidoDTO {

	private long idPedido;
	
	private String cupomFiscal;

	public PedidoDTO(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.cupomFiscal = pedido.getCupomFiscal();
	}

	public long getIdPedido() {
		return idPedido;
	}

	public String getCupomFiscal() {
		return cupomFiscal;
	}

	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}
