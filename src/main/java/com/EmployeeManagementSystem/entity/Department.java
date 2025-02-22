package com.EmployeeManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private int departmentId;

    public Department() {
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getEmployeeListInDepartment() {
        return employeeListInDepartment;
    }

    @JsonProperty
    @NotBlank
    private String departmentName;

    public void setEmployeeListInDepartment(List<Employee> employeeListInDepartment) {
        this.employeeListInDepartment = employeeListInDepartment;
    }

    @OneToMany(mappedBy = "employeeDepartment" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonProperty
    private List<Employee> employeeListInDepartment;

    public void setProjectsMappedToDepartment(List<Project> projectsMappedToDepartment) {
        this.projectsMappedToDepartment = projectsMappedToDepartment;
    }

    public List<Project> getProjectsMappedToDepartment() {
        return projectsMappedToDepartment;
    }

    @OneToMany(mappedBy = "departmentLinkedWithProject", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonProperty
    private List<Project> projectsMappedToDepartment;


}
