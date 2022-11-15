package MarketPlace.MarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MarketPlace.MarketPlace.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long >{
	
	List<Usuario> findByIdUsuario(long idUsuario);
	
	@Query("Select u from Usuario u where u.idUsuario = :idUsuario")
	List<Usuario> buscarPorIdUsuario(@Param("idUsuario") long idUsuario);
	
	List<Usuario> findByEmail(String email);
	
	@Query("Select u from Usuario u where u.email = :email")
	List<Usuario>buscarPorEmail(@Param("email")String email);
}


