package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.UserCreateDTO;
import com.springlove.simple_management_employee.dto.UserResponseDTO;
import com.springlove.simple_management_employee.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /users
    @GetMapping("/users")
    public List<UserResponseDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    // GET /users/username
    @GetMapping("/users/{username}")
    public UserResponseDTO findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    // POST /users
    @PostMapping("/users")
    public UserResponseDTO createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

}
