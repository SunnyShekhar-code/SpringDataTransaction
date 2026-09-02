package in.strikes.jpaRelationShipDemo.service;

import org.springframework.stereotype.Service;

import in.strikes.jpaRelationShipDemo.model.Department;
import in.strikes.jpaRelationShipDemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;


@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }
    
}
