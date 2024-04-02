package com.jwt.tareajwt.models.validation;

import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.models.dtos.ResponseDTO;

public class UserValidation {

	public ResponseDTO validate(UserEntity user) {
		ResponseDTO response = new ResponseDTO();
		
		response.setNumOfErrors(0);
		
		if(user.getFirstName() == null || 
				user.getFirstName().length() < 3 || 
				user.getFirstName().length() > 15) {
			response.setNumOfErrors(response.getNumOfErrors() + 1);
			response.setMessage("The name must contain between 3 and 15 characters");
		}
		
		if(user.getUsername() == null || 
				user.getUsername().length() < 3 || 
				user.getUsername().length() > 15) {
			response.setNumOfErrors(response.getNumOfErrors() + 1);
			response.setMessage("The username must contain between 3 and 20 characters");
		}
		
		if(user.getEmail() == null || 
				user.getEmail().length() < 3 || 
				!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			response.setNumOfErrors(response.getNumOfErrors() + 1);
			response.setMessage("Email invalid");
		}
		
		
		
		return response;
	}
}
