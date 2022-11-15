package MarketPlace.MarketPlace.Controller.Form;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.Produto_carrinho;
import MarketPlace.MarketPlace.repository.Produto_carrinhoRepository;

public class AtualizacaoProduto_carrinhoForm {

	@NotNull
	private int qtdItensCompra;

	public int getQtdItensCompra() {
		return qtdItensCompra;
	}

	public void setQtdItensCompra(int qtdItensCompra) {
		this.qtdItensCompra = qtdItensCompra;
	}

	public Produto_carrinho atualizar(long idProdutoCarrinho, Produto_carrinhoRepository produto_carrinhoRepository) {
		// TODO Auto-generated method stub
		Produto_carrinho prod_ca = produto_carrinhoRepository.getOne(idProdutoCarrinho);
		prod_ca.setQtdItensCompra(this.qtdItensCompra);

		return prod_ca;
	}
}
