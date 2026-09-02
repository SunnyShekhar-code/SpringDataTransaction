package in.strikes.jpaRelationShipDemo.service;

import org.springframework.stereotype.Service;

import in.strikes.jpaRelationShipDemo.model.Student;
import in.strikes.jpaRelationShipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;


@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }

    
}
