package MarketPlace.MarketPlace.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    @Id
	  	private long idUsuario;
	    
		private String senha;
		
		private String nomeUsuario;
		
		private String email;
		
		private String cpf;
		
		@ManyToOne
		@JoinColumn(name="endereco_id")
		private Endereco endereco;
		
		public Usuario() {
			
		}
		
		public Usuario (long idUsuario, String senha, String nomeUsuario, String email, String cpf,Endereco endereco) {

			setIdUsuario(idUsuario);
			setSenha(senha);
			setNomeUsuario(nomeUsuario);
			setEmail(email);
			setCpf(cpf);
			setEndereco(endereco);

		}
		
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
}
