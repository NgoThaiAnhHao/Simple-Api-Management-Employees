package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeSkillDTO;

public interface EmployeeSkillService {
    void addSkillForEmployee(Integer employeeId, EmployeeSkillDTO employeeSkillDTO);
}
