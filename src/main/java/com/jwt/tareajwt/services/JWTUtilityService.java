package com.jwt.tareajwt.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;


import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

public interface JWTUtilityService {

	String generateToken(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, JOSEException;

	JWTClaimsSet parseJWT(String jwt) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, ParseException, JOSEException;
	

}
