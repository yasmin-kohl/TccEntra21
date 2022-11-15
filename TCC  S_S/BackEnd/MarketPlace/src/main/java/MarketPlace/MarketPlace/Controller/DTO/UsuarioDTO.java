package MarketPlace.MarketPlace.Controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import MarketPlace.MarketPlace.Modelo.Usuario;

public class UsuarioDTO {
	
	private long idUsuario;
	
	private String senha;
	
	private String nomeUsuario;
	
	private String email;
	
	private String cpf;

	public UsuarioDTO(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.senha = usuario.getSenha();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
}
