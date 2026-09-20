package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.jpaRelationShipDemo.model.TransferRecord;

public interface TransferRecordRepository extends JpaRepository<TransferRecord,Long> {
    
}
