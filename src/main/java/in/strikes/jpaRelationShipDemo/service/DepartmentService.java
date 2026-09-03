package in.strikes.jpaRelationShipDemo.service;

import org.springframework.stereotype.Service;

import in.strikes.jpaRelationShipDemo.model.Department;
import in.strikes.jpaRelationShipDemo.model.Student;
import in.strikes.jpaRelationShipDemo.repository.DepartmentRepository;
import in.strikes.jpaRelationShipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;


@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,StudentRepository studentRepository){
        this.departmentRepository=departmentRepository;
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department,String studentName){
        Student student=new Student();

        student.setName(studentName);
        student.setDepartment(department);

        studentRepository.save(student);

        department.getStudents().add(student);
        departmentRepository.save(department);
    }



    
}
