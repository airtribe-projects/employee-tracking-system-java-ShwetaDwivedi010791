package com.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    @Query(value="Select * from employee where employee_id not in (select " +
            "distinct(employee_list_employee_id) from employee_project_list)" , nativeQuery = true)
    public Collection<Employee> findEmployeesWithNullProjectId();
}
