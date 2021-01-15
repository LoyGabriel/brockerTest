package com.gloy.brokertest.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gloy.brokertest.dto.UserDTO;
import com.gloy.brokertest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public Collection<UserDTO> getUsers() {
		return userRepository.findAll();
	}

	public UserDTO getUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public UserDTO createUser(UserDTO userDTO) {
		return userRepository.save(userDTO);
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

}
