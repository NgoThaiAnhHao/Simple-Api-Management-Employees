package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.EmployeeProjectCreateDTO;
import com.springlove.simple_management_employee.entity.EmployeeProject;
import com.springlove.simple_management_employee.service.EmployeeProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeProjectController {
    private final EmployeeProjectService employeeProjectService;

    public EmployeeProjectController(EmployeeProjectService employeeProjectService) {
        this.employeeProjectService = employeeProjectService;
    }

    // GET api/employees/projects
    @GetMapping("/employees/projects")
    public List<EmployeeProject> findAll() {
        return employeeProjectService.findAll();
    }

    // POST api/employees/{id}/projects
    @PostMapping("/employees/{id}/projects")
    public EmployeeProject addNewEmployeesForProjects(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeeProjectCreateDTO employeeProjectCreateDTO) {
        return employeeProjectService.addNewEmployeeForProject(id, employeeProjectCreateDTO);
    }
}
