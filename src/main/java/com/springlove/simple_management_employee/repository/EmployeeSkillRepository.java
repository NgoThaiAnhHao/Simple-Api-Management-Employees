package com.springlove.simple_management_employee.repository;

import com.springlove.simple_management_employee.entity.EmployeeSkill;
import com.springlove.simple_management_employee.entity.EmployeeSkillId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, EmployeeSkillId> {
}
