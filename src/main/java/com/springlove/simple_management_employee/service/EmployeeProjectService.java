package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeProjectCreateDTO;
import com.springlove.simple_management_employee.entity.EmployeeProject;

import java.util.List;

public interface EmployeeProjectService {
    List<EmployeeProject> findAll();

    EmployeeProject addNewEmployeeForProject(Integer employeeId, EmployeeProjectCreateDTO employeeProjectCreateDTO);
}
