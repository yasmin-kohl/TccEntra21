package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	private long idPedido;

	private String cupomFiscal;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Pedido() {

	}

	public Pedido(long idPedido, String cupomFiscal, Usuario usuario) {

		setIdPedido(idPedido);
		setCupomFiscal(cupomFiscal);
		setUsuario(usuario);
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public String getCupomFiscal() {
		return cupomFiscal;
	}

	public void setCupomFiscal(String cupomFiscal) {
		this.cupomFiscal = cupomFiscal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
