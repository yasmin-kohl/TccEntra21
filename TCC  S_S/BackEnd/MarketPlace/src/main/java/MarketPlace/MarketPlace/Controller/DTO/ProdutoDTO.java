package MarketPlace.MarketPlace.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import MarketPlace.MarketPlace.Modelo.Produto;

public class ProdutoDTO {

	private long idProduto;
	
	private String nomeProduto;
	
	private String urlImg;
	
	private double preco;
	
	private String dsProduto;
	
	private int qtdProduto;

	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.urlImg = produto.getUrlImg();
		this.preco = produto.getPreco();
		this.dsProduto = produto.getDsProduto();
		this.qtdProduto = produto.getQtdProduto();
	}

	public long getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public double getPreco() {
		return preco;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
}
