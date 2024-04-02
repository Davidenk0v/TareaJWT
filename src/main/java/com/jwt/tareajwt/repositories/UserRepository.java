package com.jwt.tareajwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwt.tareajwt.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
	Optional<UserEntity> findByEmail(String email);
}
