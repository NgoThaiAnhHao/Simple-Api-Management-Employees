package com.springlove.simple_management_employee.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkill {

    @EmbeddedId
    private EmployeeSkillId id;

    @ManyToOne
    @JoinColumn(name = "emp_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;

    @Column(name = "level")
    private String level;

    @Column(name = "years_experience")
    private int yearsExperience;

    public EmployeeSkill() {
    }

    public EmployeeSkill(EmployeeSkillId id, Employee employee, Skill skill, String level, int yearsExperience) {
        this.id = id;
        this.employee = employee;
        this.skill = skill;
        this.level = level;
        this.yearsExperience = yearsExperience;
    }

    public EmployeeSkillId getId() {
        return id;
    }

    public void setId(EmployeeSkillId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
}
