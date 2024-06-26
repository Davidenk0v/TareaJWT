package com.jwt.tareajwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/v1/**")
			.allowedOrigins("http://localhost:8080")
			.allowedMethods("GET", "POST")
			.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
			.allowCredentials(true)
			.maxAge(3600);
		
		registry.addMapping("/auth/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST")
			.allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
			.allowCredentials(false)
			.maxAge(3600);
		
	}
}
