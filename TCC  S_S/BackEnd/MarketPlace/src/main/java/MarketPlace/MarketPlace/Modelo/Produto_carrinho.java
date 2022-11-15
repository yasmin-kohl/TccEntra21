package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto_carrinho {

	@Id
	private long idProdutoCarrinho;

	private int qtdItensCompra;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public Produto_carrinho() {

	}

	public Produto_carrinho(long idProdutoCarrinho, int qtdItensCompra, Produto produto, Pedido pedido) {
		setIdProdutoCarrinho(idProdutoCarrinho);
		setQtdItensCompra(qtdItensCompra);
		setProduto(produto);
		setPedido(pedido);
	}

	public long getIdProdutoCarrinho() {
		return idProdutoCarrinho;
	}

	public void setIdProdutoCarrinho(long idProdutoCarrinho) {
		this.idProdutoCarrinho = idProdutoCarrinho;
	}

	public int getQtdItensCompra() {
		return qtdItensCompra;
	}

	public void setQtdItensCompra(int qtdItensCompra) {
		this.qtdItensCompra = qtdItensCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
