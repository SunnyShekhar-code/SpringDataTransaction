package in.strikes.jpaRelationShipDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

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

    public List<Student> fetchAll(){

        // Sort sort= Sort.by(Sort.Direction.ASC,"age");
        Sort sort= Sort.by(Sort.Direction.DESC,"age").and(Sort.by("name").ascending());
        List<Student> studentlist=studentRepository.findAll(sort);

        // for(Student s: studentlist){
        //     System.out.println(s);
        // }


        return studentlist;
    }

    

    
}
