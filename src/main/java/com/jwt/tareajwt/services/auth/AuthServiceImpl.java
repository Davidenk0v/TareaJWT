package com.jwt.tareajwt.services.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.models.dtos.LoginDTO;
import com.jwt.tareajwt.models.dtos.ResponseDTO;
import com.jwt.tareajwt.models.validation.UserValidation;
import com.jwt.tareajwt.repositories.UserRepository;
import com.jwt.tareajwt.services.JWTUtilityService;


@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JWTUtilityService jwtUtilityService;

	@Autowired
	private UserValidation userValidation;

	@Override
	public HashMap<String, String> login(LoginDTO login) throws Exception {
		try {
			HashMap<String, String> jwt = new HashMap<String, String>();

			Optional<UserEntity> userOptional = userRepository.findByEmail(login.getEmail());
			//Primero comprobamos si el user existe en la base de datos
			if(userOptional.isEmpty()) {
			jwt.put("error", "user not registered!");
			return jwt;
			}

			//Si existe comprobamos si la contraseña introducida es correcta
			if(verifyPassword(login.getPassword(), userOptional.get().getPassword())) {
				jwt.put("jwt", jwtUtilityService.generateToken(userOptional.get().getId()));
			}else {
				jwt.put("error", "Authentication failed");
			}
			
			return jwt;
			
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
	}
	
	@Override
	public ResponseDTO register(UserEntity user) throws Exception {
		try {
			ResponseDTO response = userValidation.validate(user);
			
			if(response.getNumOfErrors() > 0) {
				return response;
			}
			
			List<UserEntity> AllUsers = userRepository.findAll();
			
			for(UserEntity repetUser : AllUsers) {
				if(repetUser != null) {
					response.setNumOfErrors(1);
					response.setMessage("User already exists");
					return response;
				}
			}
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
			user.setPassword(encoder.encode(user.getPassword()));
			
			userRepository.save(user);
			response.setMessage("User created succesfully");
			
			return response;
			
		}catch(Exception e) {
			throw new Exception(e.toString());
		}
	}
	
	//Metodo para verificar si las contraseñas son iguales
	private boolean verifyPassword(String enteredPassword, String storedPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(enteredPassword, storedPassword);
	}
}
