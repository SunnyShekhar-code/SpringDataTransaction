package in.strikes.jpaRelationShipDemo.repository;

import org.springframework.stereotype.Repository;

import in.strikes.jpaRelationShipDemo.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);

    }

    public Student getStudent(long id){

        return entityManager.find(Student.class, id);
        
    }

    public void datachFromPersistenceContext(Student student){
        entityManager.detach(student);
    }

    public void flush(){
        entityManager.flush();
    }

    public void attachAgain(Student student){
        entityManager.merge(student);
    }
    

    public void deleteStudent(Student student){
        entityManager.remove(student);
    }


}
