package com.springlove.simple_management_employee.entity;

import com.springlove.simple_management_employee.enums.SkillCategory;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private int id;

    @Column(name = "skill_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_category")
    private SkillCategory category;

    @PrePersist
    protected void onCreate() {
        this.category = SkillCategory.BACKEND;
    }

    public Skill() {
    }

    public Skill(int id, String name, SkillCategory category, boolean deleted) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillCategory getCategory() {
        return category;
    }

    public void setCategory(SkillCategory category) {
        this.category = category;
    }

}
