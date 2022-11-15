package MarketPlace.MarketPlace.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import MarketPlace.MarketPlace.Modelo.Produto_carrinho;

public class Produto_carrinhoDTO {

	private long idProdutoCarrinho;
	
	private int qtdItensCompra;

	public Produto_carrinhoDTO(Produto_carrinho produto_carrinho) {
		this.idProdutoCarrinho = produto_carrinho.getIdProdutoCarrinho();
		this.qtdItensCompra = produto_carrinho.getQtdItensCompra();
	}

	public long getIdProdutoCarrinho() {
		return idProdutoCarrinho;
	}

	public int getQtdItensCompra() {
		return qtdItensCompra;
	}

	public static List<Produto_carrinhoDTO> converter(List<Produto_carrinho> produtos_carrinhos) {
		return produtos_carrinhos.stream().map(Produto_carrinhoDTO::new).collect(Collectors.toList());
	}
}
