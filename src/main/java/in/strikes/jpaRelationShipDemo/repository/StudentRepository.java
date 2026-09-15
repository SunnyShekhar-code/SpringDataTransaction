package in.strikes.jpaRelationShipDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import in.strikes.jpaRelationShipDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public interface StudentRepository extends JpaRepository<Student,Long>{

    // Student save(Student student);
    // Optional<Student> findById(Long id);

    
}