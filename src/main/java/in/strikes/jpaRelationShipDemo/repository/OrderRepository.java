package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.jpaRelationShipDemo.model.OrderProduct;

public interface OrderRepository extends JpaRepository<OrderProduct,Long> {
    
}
