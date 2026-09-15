package in.strikes.jpaRelationShipDemo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import in.strikes.jpaRelationShipDemo.model.Student;
import in.strikes.jpaRelationShipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;



@Service
public class StudentService {
    private StudentRepository studentRepository;
   
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
        
    }


    @Transactional
    public void createStudent(Student student){

        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        Optional<Student> optionalStudent=studentRepository.findById(id);
        return optionalStudent.get();
    }

    

    
}
