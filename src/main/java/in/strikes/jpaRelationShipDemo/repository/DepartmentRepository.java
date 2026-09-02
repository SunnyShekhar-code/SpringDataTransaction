package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.stereotype.Repository;

import in.strikes.jpaRelationShipDemo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Department department){
        entityManager.persist(department);
    }

    public Department getDepartment(Long id){
        return entityManager.find(Department.class, id);
    }
    
    
    
}
