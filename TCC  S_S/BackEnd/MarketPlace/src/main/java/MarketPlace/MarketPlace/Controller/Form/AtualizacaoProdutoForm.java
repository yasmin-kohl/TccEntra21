package MarketPlace.MarketPlace.Controller.Form;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.Produto;
import MarketPlace.MarketPlace.repository.ProdutoRepository;

public class AtualizacaoProdutoForm {

	@NotNull
	private String nomeProduto;

	@NotNull
	private String urlImg;

	@NotNull
	private double preco;

	@NotNull
	private String dsProduto;

	@NotNull
	private int qtdProduto;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Produto atualizar(long idProduto, ProdutoRepository produtoRepository) {

		Produto prod = produtoRepository.getOne(idProduto);
		prod.setNomeProduto(this.nomeProduto);

		return prod;
	}

	public Produto atualizar1(long idProduto, ProdutoRepository produtoRepository) {

		Produto prod = produtoRepository.getOne(idProduto);
		prod.setUrlImg(this.urlImg);

		return prod;
	}

	public Produto atualizar2(long idProduto, ProdutoRepository produtoRepository) {

		Produto prod = produtoRepository.getOne(idProduto);
		prod.setPreco(this.preco);

		return prod;
	}

	public Produto atualizar3(long idProduto, ProdutoRepository produtoRepository) {

		Produto prod = produtoRepository.getOne(idProduto);
		prod.setDsProduto(this.dsProduto);

		return prod;
	}

	public Produto atualizar4(long idProduto, ProdutoRepository produtoRepository) {

		Produto user = produtoRepository.getOne(idProduto);
		user.setQtdProduto(this.qtdProduto);

		return user;
	}
}
