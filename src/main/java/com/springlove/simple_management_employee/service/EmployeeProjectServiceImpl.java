package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeProjectCreateDTO;
import com.springlove.simple_management_employee.entity.Employee;
import com.springlove.simple_management_employee.entity.EmployeeProject;
import com.springlove.simple_management_employee.entity.EmployeeProjectId;
import com.springlove.simple_management_employee.entity.Project;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.repository.EmployeeProjectRepository;
import com.springlove.simple_management_employee.repository.EmployeeRepository;
import com.springlove.simple_management_employee.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService{
    private final EmployeeProjectRepository employeeProjectRepository;

    private final EmployeeService employeeService;

    private final ProjectService projectService;

    public EmployeeProjectServiceImpl(EmployeeProjectRepository employeeProjectRepository, EmployeeService employeeService, ProjectService projectService) {
        this.employeeProjectRepository = employeeProjectRepository;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @Override
    public List<EmployeeProject> findAll() {
        return employeeProjectRepository.findAll();
    }

    @Override
    @Transactional
    public EmployeeProject addNewEmployeeForProject(Integer employeeId, EmployeeProjectCreateDTO employeeProjectCreateDTO) {
        // Create entity
        Employee employee = employeeService.findEmployeeByEmployeeId(employeeId);
        Project project = projectService.findProjectByProjectId(employeeProjectCreateDTO.getProjectId());

        // Create composite key
        EmployeeProjectId id = new EmployeeProjectId(employeeId, employeeProjectCreateDTO.getProjectId());

        // Create new entity
        EmployeeProject employeeProject = new EmployeeProject();

        employeeProject.setId(id);
        employeeProject.setRole(employeeProjectCreateDTO.getRole());
        employeeProject.setJoinDate(employeeProjectCreateDTO.getJoinDate());
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);

        return employeeProjectRepository.save(employeeProject);
    }
}
