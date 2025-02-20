package com.EmployeeManagementSystem.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Employee {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private int employeeId;

    @JsonProperty
    @NotBlank
    private String employeeName;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty
    @Email
    private String employeeEmail;

    @JsonProperty
    @NotBlank
    private String employeeDesignation;

    @JsonProperty
    private Long employeeSalary;


    @ManyToOne
    @JsonProperty
    private Department employeeDepartment;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonProperty
    private List<Project> projectList;


    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee() {
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
