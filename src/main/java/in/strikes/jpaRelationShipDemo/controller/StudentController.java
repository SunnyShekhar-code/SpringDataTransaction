package in.strikes.jpaRelationShipDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable long id) throws Exception{
        studentService.updateStudent(student,id);
        return ResponseEntity.ok("Student updated Successfully");

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
        Student result=studentService.getStudent(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) throws Exception{
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


    
}
