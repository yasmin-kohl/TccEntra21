package MarketPlace.MarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MarketPlace.MarketPlace.Modelo.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByIdProduto(long idProduto);
	
	@Query("Select pr from Produto pr where pr.idProduto = :idProduto")
	List<Produto> buscarPorIdProduto(@Param("idProduto") long idProduto);
}
