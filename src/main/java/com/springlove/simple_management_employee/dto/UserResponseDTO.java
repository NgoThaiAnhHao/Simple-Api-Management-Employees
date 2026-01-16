package com.springlove.simple_management_employee.dto;

import java.util.List;

public class UserResponseDTO {
    private String username;

    private boolean enabled;

    private List<String> roles;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String username, boolean enabled, List<String> roles) {
        this.username = username;
        this.enabled = enabled;
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
