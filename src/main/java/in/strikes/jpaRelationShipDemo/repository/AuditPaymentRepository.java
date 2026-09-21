package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.jpaRelationShipDemo.model.AuditPayment;

public interface AuditPaymentRepository extends JpaRepository<AuditPayment,Long>{

    
}