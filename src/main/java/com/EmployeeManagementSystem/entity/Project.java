package com.EmployeeManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Project {

    @Id

    private int projectId;

    @JsonProperty
    private String projectName;

    public double getProjectAnnualBudgetInInr() {
        return projectAnnualBudgetInInr;
    }

    public void setProjectAnnualBudgetInInr(double projectAnnualBudgetInInr) {
        this.projectAnnualBudgetInInr = projectAnnualBudgetInInr;
    }

    double projectAnnualBudgetInInr;


    @ManyToMany(mappedBy = "projectList", cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JsonProperty
    private List<Employee> employeeList;


    public Department getDepartmentLinkedWithProject() {
        return departmentLinkedWithProject;
    }

    public void setDepartmentLinkedWithProject(Department departmentLinkedWithProject) {
        this.departmentLinkedWithProject = departmentLinkedWithProject;
    }

    @ManyToOne
    @JsonProperty
    private Department departmentLinkedWithProject;

}
