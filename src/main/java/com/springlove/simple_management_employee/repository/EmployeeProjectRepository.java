package com.springlove.simple_management_employee.repository;

import com.springlove.simple_management_employee.entity.EmployeeProject;
import com.springlove.simple_management_employee.entity.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, EmployeeProjectId> {
}
