package com.jwt.tareajwt.services.auth;

import java.util.HashMap;

import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.models.dtos.LoginDTO;
import com.jwt.tareajwt.models.dtos.ResponseDTO;

public interface AuthService {

	public HashMap<String, String> login(LoginDTO login) throws Exception ;
	
	public ResponseDTO register(UserEntity user) throws Exception ;
}
