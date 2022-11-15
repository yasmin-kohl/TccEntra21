package MarketPlace.MarketPlace.Controller.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import MarketPlace.MarketPlace.Modelo.Endereco;
import MarketPlace.MarketPlace.Modelo.Usuario;

public class UsuarioForm {


	private long idUsuario;

	@NotNull
	@NotEmpty
	private String senha;

	@NotNull
	@NotEmpty
	private String nomeUsuario;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String cpf;

	@NotNull
	private Endereco endereco;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario converter() {
		// TODO Auto-generated method stub
		return new Usuario(idUsuario, senha, nomeUsuario, email, cpf, endereco);
	}
}
