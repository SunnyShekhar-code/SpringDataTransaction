package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.jpaRelationShipDemo.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {



}
