package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeSkillDTO;
import com.springlove.simple_management_employee.entity.EmployeeSkill;
import com.springlove.simple_management_employee.entity.EmployeeSkillId;
import com.springlove.simple_management_employee.exception.common.AlreadyExistsException;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.repository.EmployeeRepository;
import com.springlove.simple_management_employee.repository.EmployeeSkillRepository;
import com.springlove.simple_management_employee.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService{
    private final EmployeeSkillRepository employeeSkillRepository;

    private final EmployeeRepository employeeRepository;

    private final SkillRepository skillRepository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepository, EmployeeRepository employeeRepository, SkillRepository skillRepository) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    @Transactional
    public void addSkillForEmployee(Integer employeeId, EmployeeSkillDTO employeeSkillDTO) {
        int skillId = employeeSkillDTO.getSkillId();
        String level = employeeSkillDTO.getLevel();
        int yearsExperience = employeeSkillDTO.getYearsExperience();

        // Checking exist employee
        if (!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee not found");
        }

        // Checking exist skill
        if (!skillRepository.existsById(skillId)) {
            throw new ResourceNotFoundException("Skill not found");
        }

        // Create composite key
        EmployeeSkillId id = new EmployeeSkillId(employeeId, skillId);

        // Check duplicate
        if (employeeSkillRepository.existsById(id)) {
            throw new AlreadyExistsException("Employee already has this skill");
        }

        // Create new entity
        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setId(id);
        employeeSkill.setLevel(level);
        employeeSkill.setYearsExperience(yearsExperience);

        // Save
        employeeSkillRepository.save(employeeSkill);
    }
}
