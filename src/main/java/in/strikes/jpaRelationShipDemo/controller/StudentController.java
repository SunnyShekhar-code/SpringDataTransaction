package in.strikes.jpaRelationShipDemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.jpaRelationShipDemo.model.Student;
import in.strikes.jpaRelationShipDemo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        return ResponseEntity.ok("Done");

    }

    @GetMapping ("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable  Long id){
        Student student=studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<Student>> getAllStudent(@RequestParam int pageNo, @RequestParam  int size ){
        return ResponseEntity.ok(studentService.fetchByPage(size, pageNo));
    }

    @GetMapping ("/name")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentService.fetchAll());
    }



   

}
