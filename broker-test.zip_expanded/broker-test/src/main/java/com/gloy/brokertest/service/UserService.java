package com.gloy.brokertest.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gloy.brokertest.dto.UserDTO;
import com.gloy.brokertest.repository.LoanRepository;
import com.gloy.brokertest.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	LoanRepository loanRepository;

	@Autowired
	UserRepository userRepository;

	public Collection<UserDTO> getUsers() {
		return userRepository.findAll();
	}

	public UserDTO getUserById(int userId) throws Exception{
		try {
			return userRepository.findById(userId).orElse(null);
		} catch (Exception e) {
			throw new EntityNotFoundException("User with id " + userId + " not found");
		}
	}

	public UserDTO createUser(UserDTO userDTO) throws Exception {
		try {
			return userRepository.save(userDTO);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void deleteUser(int userId) throws Exception{
		try {
			userRepository.deleteById(userId);
		}catch(IllegalArgumentException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserId can't be null");
		}
		catch(EntityNotFoundException e) {
			throw new EntityNotFoundException(HttpStatus.NOT_FOUND + " User with id " +userId+ "not Found");
		}catch (Exception e) {
			System.out.println("Error en el delete "+e.getMessage());
		}
	}
	
	public List<UserDTO> addAll(List<UserDTO> users){
		return userRepository.saveAll(users);
	}

}
