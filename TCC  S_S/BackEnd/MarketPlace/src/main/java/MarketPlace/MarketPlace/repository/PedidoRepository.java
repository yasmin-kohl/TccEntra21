package MarketPlace.MarketPlace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import MarketPlace.MarketPlace.Modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
	
	List<Pedido> findByIdPedido(long idPedido);
	
	@Query("Select p from Pedido p where p.idPedido = :idPedido")
	List<Pedido> buscarPorIdPedido(@Param("idPedido") long idPedido);
	
}
