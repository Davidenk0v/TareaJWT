package com.jwt.tareajwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwt.tareajwt.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
	Optional<UserEntity> findByEmail(String email);
}
