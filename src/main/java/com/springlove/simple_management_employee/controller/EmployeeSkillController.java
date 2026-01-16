package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.EmployeeSkillDTO;
import com.springlove.simple_management_employee.service.EmployeeSkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeSkillController {
    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping("employees/{id}/skills")
    public void addSkillForEmployee(
            @PathVariable int id,
            @Valid @RequestBody EmployeeSkillDTO employeeSkillDTO) {
        employeeSkillService.addSkillForEmployee(id, employeeSkillDTO);
    }
}
