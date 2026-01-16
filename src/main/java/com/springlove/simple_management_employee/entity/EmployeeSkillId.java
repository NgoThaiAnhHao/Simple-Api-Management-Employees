package com.springlove.simple_management_employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmployeeSkillId implements Serializable {

    @Column(name = "emp_id")
    private int employeeId;

    @Column(name = "skill_id")
    private int skillId;

    public EmployeeSkillId() {
    }

    public EmployeeSkillId(int employeeId, int skillId) {
        this.employeeId = employeeId;
        this.skillId = skillId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
