package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.EmployeePatchDTO;
import com.springlove.simple_management_employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    Employee findEmployeeByEmployeeId(Integer id);

    Employee addNewEmployee(EmployeeCreateUpdateDTO employeeCreateUpdateDTO);

    Employee updateEmployee(int id, EmployeeCreateUpdateDTO employeeCreateUpdateDTO);

    Employee updatePartialEmployee(int id, EmployeePatchDTO employeePatchDTO);

    void deleteEmployeeByEmployeeId(int id);
}
