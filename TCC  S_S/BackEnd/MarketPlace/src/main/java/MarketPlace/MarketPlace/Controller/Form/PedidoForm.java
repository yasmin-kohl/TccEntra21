package MarketPlace.MarketPlace.Controller.Form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.Pedido;
import MarketPlace.MarketPlace.Modelo.Usuario;

public class PedidoForm {
	
	@NotNull
	@NotEmpty
	private long idPedido;
	
	@NotNull
	@NotEmpty
	private String culpomFiscal;

	@NotNull
	@NotEmpty
	private Usuario usuario;

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public String getCulpomFiscal() {
		return culpomFiscal;
	}

	public void setCulpomFiscal(String culpomFiscal) {
		this.culpomFiscal = culpomFiscal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pedido converter() {
		return new Pedido(idPedido, culpomFiscal, usuario);
	}
}
