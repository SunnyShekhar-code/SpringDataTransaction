package in.strikes.jpaRelationShipDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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


        

    
}
