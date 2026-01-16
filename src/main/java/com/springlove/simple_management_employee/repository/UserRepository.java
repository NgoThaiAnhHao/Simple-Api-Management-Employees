package com.springlove.simple_management_employee.repository;

import com.springlove.simple_management_employee.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String username);
}
