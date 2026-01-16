package com.springlove.simple_management_employee.dto;

import com.springlove.simple_management_employee.enums.EmployeeStatus;
import jakarta.validation.constraints.NotBlank;


public class EmployeeCreateUpdateDTO {
    @NotBlank(message = "Name must be valid")
    private String name;

    @NotBlank(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Employee status must be formated ACTIVE/INACTIVE")
    private EmployeeStatus employeeStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
