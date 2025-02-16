package com.EmployeeManagementSystem.service;


import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.entity.Project;
import com.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
       return departmentRepository.save(department);
    }

    public Department getDepartmentById(int id) {
       return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Department department) {
       Department fetchedDepartment= departmentRepository.
               findById(department.getDepartmentId()).orElse(null);
       if(fetchedDepartment!=null){
           fetchedDepartment.setDepartmentName(department.getDepartmentName());
          List<Employee> fetchedEmployeeList=fetchedDepartment.getEmployeeListInDepartment();
          for(Employee e: department.getEmployeeListInDepartment()){
              fetchedEmployeeList.add(e);
          }
           return departmentRepository.save(fetchedDepartment);
       }
       else return null;
    }

    public double getDeparmentBudget(int id) {
        Department fetchedDepartment= departmentRepository.findById(id).orElse(null);
        double sum=0;
        if(fetchedDepartment!=null){
            for(Project p: fetchedDepartment.getProjectsMappedToDepartment()){
                sum=sum+p.getProjectAnnualBudgetInInr();
            }
        }
        return sum;

    }
}
