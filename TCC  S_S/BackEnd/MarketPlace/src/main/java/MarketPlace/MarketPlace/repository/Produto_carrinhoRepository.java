package MarketPlace.MarketPlace.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import MarketPlace.MarketPlace.Modelo.Produto_carrinho;


public interface Produto_carrinhoRepository extends JpaRepository<Produto_carrinho, Long> {
	
	List<Produto_carrinho> findByIdProdutoCarrinho(long idProdutoCarrinho);

	@Query("Select c from Produto_carrinho c where c.idProdutoCarrinho = :idProdutoCarrinho")
	List<Produto_carrinho> buscarPorIdProdutoCarrinho(@Param("idProdutoCarrinho") long idProdutoCarrinho);
}
