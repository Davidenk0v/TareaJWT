package com.jwt.tareajwt.services;

import java.util.List;


import com.jwt.tareajwt.entities.UserEntity;

public interface UserService {

	public List<UserEntity> findAllUsers();
}