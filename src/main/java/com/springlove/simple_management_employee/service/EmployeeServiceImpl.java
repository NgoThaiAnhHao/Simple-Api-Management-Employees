package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.EmployeeCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.EmployeePatchDTO;
import com.springlove.simple_management_employee.entity.Employee;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Fields
    private final EmployeeRepository employeeRepository;

    // Constructor
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // GET /api/employees
    // Find All Employees
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET /api/employees/{id}
    // Find Employee By ID
    @Override
    public Employee findEmployeeByEmployeeId(Integer id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(
                () -> new ResourceNotFoundException("Employee Not Found (Id = " + id + ")")
        );
    }

    // POST /api/employees
    // Add New Employee
    @Override
    @Transactional
    public Employee addNewEmployee(EmployeeCreateUpdateDTO employeeCreateUpdateDTO) {
        Employee employee = new Employee();

        employee.setName(employeeCreateUpdateDTO.getName());
        employee.setEmail(employeeCreateUpdateDTO.getEmail());

        return employeeRepository.save(employee);
    }

    // PUT /api/employees/{id}
    // Update New Employee
    @Override
    @Transactional
    public Employee updateEmployee(int id, EmployeeCreateUpdateDTO employeeCreateUpdateDTO) {
        Employee employee = findEmployeeByEmployeeId(id);

        employee.setName(employeeCreateUpdateDTO.getName());
        employee.setEmail(employeeCreateUpdateDTO.getEmail());

        return employeeRepository.save(employee);
    }

    // PATCH /api/employees/{id}
    // Update partials for Employee
    @Override
    @Transactional
    public Employee updatePartialEmployee(int id, EmployeePatchDTO employeePatchDTO) {
        Employee employee = findEmployeeByEmployeeId(id);

        if (employeePatchDTO.getName() != null) {
            employee.setName(employeePatchDTO.getName());
        }

        if (employeePatchDTO.getEmployeeStatus() != null) {
            employee.setStatus(employeePatchDTO.getEmployeeStatus());
        }

        if (employeePatchDTO.getEmail() != null) {
            employee.setEmail(employeePatchDTO.getEmail());
        }

        return employeeRepository.save(employee);
    }

    // DELETE /api/employees/{id}
    // Delete Employee By Employee Id
    @Override
    @Transactional
    public void deleteEmployeeByEmployeeId(int id) {
        employeeRepository.deleteById(id);
    }


}
