package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.UserCreateDTO;
import com.springlove.simple_management_employee.dto.UserResponseDTO;
import com.springlove.simple_management_employee.entity.UserEntity;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

/** NOTE
 *
 * @UserDetails:
 *          - Spring Security just connect with UserDetails.
 *          - Include in this class:
 *              + String getUsername();
 *              + boolean isEnabled();
 *              + Collection<? extends GrantedAuthority> getAuthorities()
 *
 *
 * @UserDetailsManager:
 *          - UserDetailsManager is UserDetailsService and CRUD user
 *          - Include in this class:
 *              + void createUser(UserDetails user);
 *
 *
 * @UserRepository:
 *          - UserRepository is access the database and get data by JPA/JDBC
 *          - Include in this class:
 *              + List<UserEntity> findAll();
 *
 */
@Service
public class UserServiceImpl implements UserService{

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> findAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userEntity -> convertUserEntityToUserResponseDTO(userEntity))
                .toList();
    }

    @Override
    public UserResponseDTO findUserByUsername(String username) {
        UserEntity userEntity = userRepository.findUserByUsername(username);

        if (userEntity == null) {
            throw new ResourceNotFoundException("User Not Found!");
        }

        return convertUserEntityToUserResponseDTO(userEntity);
    }

    @Override
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        // Create new user for userDetails
        UserDetails userDetails = User.builder()
                .username(userCreateDTO.getUsername())
                .password(passwordEncoder.encode(userCreateDTO.getPassword()))
                .roles(userCreateDTO.getRole())
                .build();

        // Add to userDetail list
        userDetailsManager.createUser(userDetails);

        // Declare UserEntity from new UserDetail
        UserEntity userEntity = userRepository.findUserByUsername(userDetails.getUsername());

        // Return user by userResponseDTO format
        return convertUserEntityToUserResponseDTO(userEntity);
    }

    @Override
    public UserResponseDTO convertUserEntityToUserResponseDTO(UserEntity userEntity) {
            // Find userDetails in list by username
            UserDetails userDetails = userDetailsManager.loadUserByUsername(userEntity.getUsername());

            // Get Roles From userDetails
            List<String> roles = userDetails
                    .getAuthorities()
                    .stream()
                    .map(authority -> authority.getAuthority())
                    .toList();

            // Return userResponseDTO format
            return new UserResponseDTO(
                    userDetails.getUsername(),
                    userDetails.isEnabled(),
                    roles
            );

    }


}
