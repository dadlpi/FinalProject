package com.skilldistillery.carwash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.carwash.entities.Service;
import com.skilldistillery.carwash.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	Store findByUser_UsernameAndId(String username, int storeId);
	//Store findByName(String name);
	Store findById(int storeId);
}