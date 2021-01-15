package com.gloy.brokertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gloy.brokertest.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Integer>{

}
