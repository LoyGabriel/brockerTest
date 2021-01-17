package com.gloy.brokertest.resource;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gloy.brokertest.dto.UserDTO;
import com.gloy.brokertest.service.UserService;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(value="")
	public Collection<UserDTO> getUsers() {
		return userService.getUsers();
	}
	
	
	@GetMapping(value="/{userId}")
	public UserDTO getUserById(@PathVariable(value = "userId") Integer userId)throws Exception {
		if(!Objects.isNull(userId)) {
			return userService.getUserById(userId);
		}else {
			throw new BadHttpRequest();
		}
	}
	
	@PostMapping(value="",produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception{
		return userService.createUser(userDTO);
	}
	
	
	@DeleteMapping(value="/{userId}")
	public void deleteUser(@PathVariable(value = "userId") int userId) throws Exception{
		userService.deleteUser(userId);
	}
}
