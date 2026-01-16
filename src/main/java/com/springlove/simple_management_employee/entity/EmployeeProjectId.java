package com.springlove.simple_management_employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeProjectId {

    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "project_id")
    private int projectId;

    public EmployeeProjectId() {
    }

    public EmployeeProjectId(int employeeId, int projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
