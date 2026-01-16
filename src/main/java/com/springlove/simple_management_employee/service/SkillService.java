package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.SkillCreateDTO;
import com.springlove.simple_management_employee.entity.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> findAllSkills();

    Skill addNewSkill(SkillCreateDTO skillCreateDTO);
}
