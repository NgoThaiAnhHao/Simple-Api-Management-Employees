package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.SkillCreateDTO;
import com.springlove.simple_management_employee.entity.Skill;
import com.springlove.simple_management_employee.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{
    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    @Transactional
    public Skill addNewSkill(SkillCreateDTO skillCreateDTO) {
        Skill skill = new Skill();

        skill.setName(skillCreateDTO.getName());
        skill.setCategory(skillCreateDTO.getCategory());

        return skillRepository.save(skill);
    }

}
