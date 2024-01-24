package com.skilldistillery.carwash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.carwash.entities.User;
import com.skilldistillery.carwash.repositories.UserRepository;
import com.skilldistillery.carwash.security.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
//		user.setEnabled(true);
//		user.setRole("standard");
//		String encryptedPassword = encoder.encode(user.getPassword());
//		user.setPassword(encryptedPassword);
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}