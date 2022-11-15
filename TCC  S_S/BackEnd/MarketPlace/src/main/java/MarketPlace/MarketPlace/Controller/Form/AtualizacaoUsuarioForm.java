package MarketPlace.MarketPlace.Controller.Form;

import com.sun.istack.NotNull;

import MarketPlace.MarketPlace.Modelo.Endereco;
import MarketPlace.MarketPlace.Modelo.Usuario;
import MarketPlace.MarketPlace.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

	@NotNull
	private String nomeUsuario;

	@NotNull
	private String senha;

	@NotNull
	private Endereco endereco;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario atualizar(long idUsuario, UsuarioRepository usuarioRepository) {

		Usuario user = usuarioRepository.getOne(idUsuario);
		user.setNomeUsuario(this.nomeUsuario);

		return user;
	}

	public Usuario atualizar1(long idUsuario, UsuarioRepository usuarioRepository) {

		Usuario user = usuarioRepository.getOne(idUsuario);
		user.setSenha(this.senha);

		return user;
	}

	public Usuario atualizar2(long idUsuario, UsuarioRepository usuarioRepository) {

		Usuario user = usuarioRepository.getOne(idUsuario);
		user.setEndereco(this.endereco);

		return user;
	}

}
