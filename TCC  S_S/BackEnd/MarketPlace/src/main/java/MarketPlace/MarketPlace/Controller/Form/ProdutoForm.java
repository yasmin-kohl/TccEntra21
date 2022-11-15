package MarketPlace.MarketPlace.Controller.Form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.CategoriaProd;
import MarketPlace.MarketPlace.Modelo.Produto;
import MarketPlace.MarketPlace.Modelo.Usuario;

public class ProdutoForm {

	@NotNull
	@NotEmpty
	private long idProduto;

	@NotNull
	@NotEmpty
	private String nomeProduto;

	@NotNull
	@NotEmpty
	private String urlImg;

	@NotNull
	@NotEmpty
	private double preco;

	@NotNull
	@NotEmpty
	private String dsProduto;

	@NotNull
	@NotEmpty
	private int qtdProduto;

	@NotNull
	@NotEmpty
	private Usuario usuario;

	@NotNull
	@NotEmpty
	private CategoriaProd categoriaProd;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CategoriaProd getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(CategoriaProd categoriaProd) {
		this.categoriaProd = categoriaProd;
	}

	public Produto converter() {
		// TODO Auto-generated method stub
		return new Produto(idProduto, nomeProduto, urlImg, preco, dsProduto, usuario, qtdProduto, categoriaProd);
	}

}
