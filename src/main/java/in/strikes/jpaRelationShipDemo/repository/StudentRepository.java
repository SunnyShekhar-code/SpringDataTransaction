package in.strikes.jpaRelationShipDemo.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.strikes.jpaRelationShipDemo.model.Student;




public interface StudentRepository extends JpaRepository<Student,Long>{
        
    // Student save(Student student);
    // Optional<Student> findById(Long id);

    @Query(value = """
            select * from Student where email=?1 and age=?2
            """, nativeQuery = true)
    Optional<Student> findByEmailAndage(String email, Long age);
    // Optional<Student> findByEmailAndage(@Param("email") String email, @Param("age") Long age);

    
}