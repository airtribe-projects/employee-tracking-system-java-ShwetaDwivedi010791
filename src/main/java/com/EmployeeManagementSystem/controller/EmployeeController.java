package com.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/ems" , consumes = "application/json", produces = "application/json")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value= "/employees/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(@PathVariable(name="id") int id ){
        Employee e= employeeService.getEmployee(id);
        if(e!=null)
        {
            return new ResponseEntity<>(e,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value="/employee")
    public Employee saveEmployee(@RequestBody  Employee e ){
       return employeeService.saveEmployee(e);
    }

    @PutMapping(value="/employees")
    public Employee updateEmployee(@RequestBody Employee e){
    return  employeeService.updateEmployee(e);
    }


}
