package com.example.Projectt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Projectt.models.users;
import com.example.Projectt.service.userService;

@RestController
@RequestMapping("/signup")
public class usercontroller {
	@Autowired
	private userService userService;
	public usercontroller (userService userService) {
		this.userService=userService;
	}
	@PostMapping("/register")
    public users registerUser(@RequestBody users user) {
		return userService.saveUser(user);
    }


}