package com.jwt.tareajwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jwt.tareajwt.models.validation.UserValidation;

@Configuration
public class ValidationsConfig {

	@Bean
	public UserValidation userValidation() {
		return new UserValidation();
	}
}
