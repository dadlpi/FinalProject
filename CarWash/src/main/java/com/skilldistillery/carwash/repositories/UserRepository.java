package com.skilldistillery.carwash.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.carwash.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
