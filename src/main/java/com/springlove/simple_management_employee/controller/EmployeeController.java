package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.EmployeeCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.EmployeePatchDTO;
import com.springlove.simple_management_employee.entity.Employee;
import com.springlove.simple_management_employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    // Fields
    private final EmployeeService employeeService;

    // Constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /api/employees
    // Find All Employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    // GET /api/employees/{id}
    // Find Employee By ID
    @GetMapping("/employees/{id}")
    public Employee findEmployeeByEmployeeId(
            @PathVariable Integer id) {
        return employeeService.findEmployeeByEmployeeId(id);
    }

    // POST /api/employees
    // Add New Employee
    @PostMapping("/employees")
    public Employee addNewEmployee(
            @Valid @RequestBody EmployeeCreateUpdateDTO employeeCreateUpdateDTO) {
        return employeeService.addNewEmployee(employeeCreateUpdateDTO);
    }

    // PUT /api/employees/{id}
    // Update New Employee
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeeCreateUpdateDTO employeeCreateUpdateDTO) {
        return employeeService.updateEmployee(id, employeeCreateUpdateDTO);
    }

    // PATCH /api/employees/{id}
    // Update partials for Employee
    @PatchMapping("/employees/{id}")
    public Employee updatePartialEmployee(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeePatchDTO employeePatchDTO) {
        return employeeService.updatePartialEmployee(id, employeePatchDTO);
    }


    // DELETE /api/employees/{id}
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeByEmployeeId(
            @PathVariable Integer id) {
        employeeService.deleteEmployeeByEmployeeId(id);
    }
}
