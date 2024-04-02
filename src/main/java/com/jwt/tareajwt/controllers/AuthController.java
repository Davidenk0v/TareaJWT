package com.jwt.tareajwt.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.models.dtos.LoginDTO;
import com.jwt.tareajwt.models.dtos.ResponseDTO;
import com.jwt.tareajwt.services.auth.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	private ResponseEntity<ResponseDTO> register(@RequestBody UserEntity user) throws Exception{
		return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	private ResponseEntity<HashMap<String, String>> login (@RequestBody LoginDTO request) throws Exception{
		HashMap<String, String> login = authService.login(request);
		if(login.containsKey("jwt")) {
			return new ResponseEntity<>(login, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
	}

}
