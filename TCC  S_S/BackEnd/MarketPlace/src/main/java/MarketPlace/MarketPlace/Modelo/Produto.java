package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {

	@Id
	private long idProduto;
	
	private String nomeProduto;
	
	private String urlImg;
	
	private double preco;
	
	private String dsProduto;
	
	private int qtdProduto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="categoriaProd_id")
	
	private CategoriaProd categoriaProd;
	
	public Produto() {

	}

	public Produto(long idProduto, String nomeProduto, String urlImg, double preco, String dsProduto, Usuario usuario,
			int qtdProduto, CategoriaProd categoriaProd) {

		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setUrlImg(urlImg);
		setPreco(preco);
		setDsProduto(dsProduto);
		setUsuario(usuario);
		setQtdProduto(qtdProduto);
		setCategoriaProd(categoriaProd);
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public CategoriaProd getIdCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(CategoriaProd categoriaProd) {
		this.categoriaProd = categoriaProd;
	}
}
