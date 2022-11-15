package MarketPlace.MarketPlace.Controller.Form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.Pedido;
import MarketPlace.MarketPlace.Modelo.Produto;
import MarketPlace.MarketPlace.Modelo.Produto_carrinho;

public class Produto_carrinhoForm {
	
	@NotNull @NotEmpty
	private long idProdutoCarrinho;
	
	@NotNull @NotEmpty
	private int qtdItensCompra;
	
	@NotNull @NotEmpty
	private Produto produto;
	
	@NotNull @NotEmpty
	private Pedido pedido;
	
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
	
	public Produto_carrinho converter() {
		return new Produto_carrinho(idProdutoCarrinho, qtdItensCompra, produto, pedido);
	}

}
