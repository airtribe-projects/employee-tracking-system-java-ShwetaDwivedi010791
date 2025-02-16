package com.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/ems")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(value="/departments")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        if(savedDepartment!=null) {
            return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value="/departments/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(name = "id") int id){
       Department fetchedDepartment= departmentService.getDepartmentById(id);
       if(fetchedDepartment!=null){
           return new ResponseEntity<>(fetchedDepartment, HttpStatus.OK);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/departments")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
       Department updatedDepartment= departmentService.updateDepartment(department);
       if(updatedDepartment!=null){
           return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
       }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @GetMapping(value="/departmentBudget/{id}")
    public ResponseEntity<Double> getDepartmentBudget(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(departmentService.getDeparmentBudget(id),HttpStatus.OK);
    }



}
