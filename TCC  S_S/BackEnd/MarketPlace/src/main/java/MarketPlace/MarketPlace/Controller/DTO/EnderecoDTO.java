package MarketPlace.MarketPlace.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;
import MarketPlace.MarketPlace.Modelo.Endereco;

public class EnderecoDTO {

	private long idEndereco;

	private String cep;

	private String rua;

	private String numero;

	private String bairro;

	private String cidade;

	private String estado;
	
	public EnderecoDTO(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
	}
	
	public long getIdEndereco() {
		return idEndereco;
	}
	
	public String getCep() {
		return cep;
	}
	
	public String getRua() {
		return rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public static List<EnderecoDTO> converter(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}
	
}
