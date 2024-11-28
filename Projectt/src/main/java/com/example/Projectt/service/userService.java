package com.example.Projectt.service;

import org.springframework.stereotype.Service;

import com.example.Projectt.models.users;
import com.example.Projectt.repository.userRepository;
@Service
public class userService {

	 private userRepository userRepository;
	 public userService (userRepository userRepository) {
		 this.userRepository=userRepository;
	 }
	 public users saveUser(users user) {
	        return userRepository.save(user);
	    }
	}
	
