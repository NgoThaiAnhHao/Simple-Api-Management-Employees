package com.springlove.simple_management_employee.dto;

import com.springlove.simple_management_employee.enums.SkillCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SkillCreateDTO {

    @NotBlank(message = "Name must be valid")
    private String name;

    @NotNull
    private SkillCategory category;

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
