package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.stereotype.Repository;

import in.strikes.jpaRelationShipDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


}
