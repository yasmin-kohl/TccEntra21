package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoriaProd {

	@Id
	private long idCategoria;
	
	private String nomeCategoria;
	
	private String dsCategoria;

	public CategoriaProd() {

	}

	public CategoriaProd(long idCategoria, String nomeCategoria, String dsCategoria) {

		setIdCategoria(idCategoria);
		setNomeCategoria(nomeCategoria);
		setDsCategoria(dsCategoria);
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDsCategoria() {
		return dsCategoria;
	}

	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
}
