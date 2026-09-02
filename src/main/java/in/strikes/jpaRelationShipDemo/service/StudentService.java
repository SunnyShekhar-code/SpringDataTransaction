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

    @Transactional
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Student student,long id) throws Exception{
        Student student1=studentRepository.getStudent(id);
        if(student1==null){
            throw new Exception("Student not found");
        }

        // studentRepository.datachFromPersistenceContext(student1);
        // studentRepository.attachAgain(student1);

        student1.setName(student.getName());
        studentRepository.flush();
        student1.setEmail(student.getEmail());
        studentRepository.flush();
        student1.setAge(student.getAge());
        

        // studentRepository.attachAgain(student1);
    }

    @Transactional
    public Student getStudent(long id){
        return studentRepository.getStudent(id);
    }

    // public List<Student> getAllStudents(){
    //     return studentRepository.getAllStudents();
    // }

    @Transactional
    public void deleteStudent(long id) throws Exception{
        Student student = studentRepository.getStudent(id);
        if(student==null) throw new Exception("Student not Found");
        studentRepository.deleteStudent(student);
    }


    
}
