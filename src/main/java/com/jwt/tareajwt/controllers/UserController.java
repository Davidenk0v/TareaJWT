package com.jwt.tareajwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		return new ResponseEntity<>(this.userService.findAllUsers(), HttpStatus.OK);
	}
}
