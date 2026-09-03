package in.strikes.jpaRelationShipDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import in.strikes.jpaRelationShipDemo.model.Department;
import in.strikes.jpaRelationShipDemo.model.Student;
import in.strikes.jpaRelationShipDemo.repository.DepartmentRepository;
import in.strikes.jpaRelationShipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;



@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    public StudentService(StudentRepository studentRepository,DepartmentRepository departmentRepository){
        this.studentRepository=studentRepository;
        this.departmentRepository=departmentRepository;

    }


    @Transactional
    public void createStudent(Student student,long dept_id){

        Department department= departmentRepository.getDepartment(dept_id);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student,String deptName){

        Department department= new Department();
        department.setName(deptName);

        student.setDepartment(department);
        department.getStudents().add(student);

        departmentRepository.save(department);
        studentRepository.save(student);
    }

    
}
