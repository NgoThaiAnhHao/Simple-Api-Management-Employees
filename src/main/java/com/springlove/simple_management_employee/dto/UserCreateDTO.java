package com.springlove.simple_management_employee.dto;

import jakarta.validation.constraints.NotBlank;

public class UserCreateDTO {

    @NotBlank(message = "Username must be valid")
    private String username;

    @NotBlank(message = "Password must be valid")
    private String password;

    @NotBlank(message = "Role must be valid - (ADMIN/USER)")
    private String role;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
