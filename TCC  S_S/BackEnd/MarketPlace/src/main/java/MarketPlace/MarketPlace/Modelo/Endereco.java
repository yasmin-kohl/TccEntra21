package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	private long idEndereco;

	private String cep;

	private String rua;

	private String numero;

	private String bairro;

	private String cidade;

	private String estado;

	public Endereco() {

	}

	public Endereco(long idEndereco, String cep, String rua, String numero, String bairro, String cidade,
			String estado) {

		setIdEndereco(idEndereco);
		setCep(cep);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
	}

	public long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
