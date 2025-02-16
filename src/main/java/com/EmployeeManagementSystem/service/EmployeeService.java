package com.EmployeeManagementSystem.service;


import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.repository.DepartmentRepository;
import com.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public Employee saveEmployee(Employee e){
        return employeeRepository.save(e);
    }

    public Employee getEmployee(int id){ return employeeRepository.findById(id).orElse(null);}

    public Employee updateEmployee(Employee e){
        Employee employee=employeeRepository.findById(e.getEmployeeID()).orElse(null);
        if(employee!=null){
            employee.setEmployeeDepartment(departmentRepository.findById(e.getEmployeeDepartment().getDepartmentId()).get());
        }
        return employeeRepository.save(employee);

    }
}
