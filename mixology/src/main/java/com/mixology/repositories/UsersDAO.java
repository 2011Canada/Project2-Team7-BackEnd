package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Users;


public interface UsersDAO extends JpaRepository<Users, Integer>{
	
	public Users findByUsernameAndPassword(String username, String password);

	public Users findUsersByUsername(String name);
}
