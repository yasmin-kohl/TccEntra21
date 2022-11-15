package MarketPlace.MarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MarketPlace.MarketPlace.Modelo.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	List<Endereco> findByIdEndereco(long idEndereco);
	
	@Query("Select e from Endereco e where e.idEndereco = :idEndereco")
	List<Endereco> buscarPorIdEndereco(@Param("idEndereco") long idEndereco);
}
