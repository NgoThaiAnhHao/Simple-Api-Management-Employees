package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.SkillCreateDTO;
import com.springlove.simple_management_employee.entity.Skill;
import com.springlove.simple_management_employee.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // GET /api/skills
    @GetMapping("/skills")
    public List<Skill> findAllSkills() {
        return skillService.findAllSkills();
    }

    // POST /api/skills
    @PostMapping("/skills")
    public Skill addNewSkill(
            @Valid @RequestBody SkillCreateDTO skillCreateDTO) {
        return skillService.addNewSkill(skillCreateDTO);
    }

}
