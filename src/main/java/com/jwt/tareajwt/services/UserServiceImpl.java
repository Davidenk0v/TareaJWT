package com.jwt.tareajwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.tareajwt.entities.UserEntity;
import com.jwt.tareajwt.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;

	@Override
	public List<UserEntity> findAllUsers() {
		return this.repository.findAll();
	}

}
