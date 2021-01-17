package com.gloy.brokertest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.gloy.brokertest.dto.LoanDTO;
import com.gloy.brokertest.dto.UserDTO;
import com.gloy.brokertest.repository.UserRepository;
import com.gloy.brokertest.service.LoanService;
import com.gloy.brokertest.service.UserService;

public class Bootstrap {
	@Autowired
	UserService userService;
	
	@Autowired 
	LoanService loanService;
	
	public void initData() {
		List<UserDTO> users = new ArrayList<>();
		List<LoanDTO> loans= new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			users.add(buildUser(i));
		}
		for(int i=150; i<200; i++) {
			loans.add(buildLoan());
		}
		userService.addAll(users);
		loanService.addAll(loans);
	}
	
	private static UserDTO buildUser(int i) {
		return new UserDTO("user"+i+"@mail.com", "FirstName"+i,"LastName"+i);
	}
	
	private LoanDTO buildLoan() {
		return new LoanDTO(generateRandomTotal(), generateRandomUserId());
	}
	
	
	private static double generateRandomTotal() {
		return Math.random()*1000;
	}
	
	private  int generateRandomUserId() {
		Random r = new Random();
		return  r.nextInt(10);
	}

}
