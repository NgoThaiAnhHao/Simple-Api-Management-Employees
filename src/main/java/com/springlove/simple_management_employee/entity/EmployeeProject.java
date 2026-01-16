package com.springlove.simple_management_employee.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_project")
public class EmployeeProject {
    @EmbeddedId
    private EmployeeProjectId id;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;

    @Column(name = "role")
    private String role;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    public EmployeeProject() {
    }

    public EmployeeProject(EmployeeProjectId id, Employee employee, Project project, String role, LocalDateTime joinDate) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.role = role;
        this.joinDate = joinDate;
    }

    public EmployeeProjectId getId() {
        return id;
    }

    public void setId(EmployeeProjectId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }
}
