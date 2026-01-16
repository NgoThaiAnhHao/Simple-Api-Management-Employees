package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.UserCreateDTO;
import com.springlove.simple_management_employee.dto.UserResponseDTO;
import com.springlove.simple_management_employee.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> findAllUsers();

    UserResponseDTO findUserByUsername(String username);

    UserResponseDTO createUser(UserCreateDTO userCreateDTO);

    UserResponseDTO convertUserEntityToUserResponseDTO(UserEntity userEntity);
}
