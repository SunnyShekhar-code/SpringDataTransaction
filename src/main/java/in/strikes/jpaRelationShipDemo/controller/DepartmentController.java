package in.strikes.jpaRelationShipDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.jpaRelationShipDemo.model.Department;
import in.strikes.jpaRelationShipDemo.service.DepartmentService;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<String>createdepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String>createdepartment(@RequestBody Department department, @RequestParam String studentName){
        departmentService.createDepartment(department,studentName);
        return ResponseEntity.ok("Done");
    }
    
}
