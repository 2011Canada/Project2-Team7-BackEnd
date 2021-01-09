package com.mixology.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mixology.models.Users;
import com.mixology.services.UserService;

@RestController 
@RequestMapping("/user")
public class UserController {

	private UserService us;

	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(us.findAllUsers(), HttpStatus.OK);
	}
	
	
	@GetMapping("/login") 
	public ResponseEntity<Users> findUsersByUsernameAndPassword(@PathVariable String username, String password) {

		return new ResponseEntity<Users>(us.findUsersByUsernameAndPassword(username, password), HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> findUsersById(@PathVariable int id) {

		return new ResponseEntity<Users>(us.findUsersById(id), HttpStatus.OK);


	}
	
	@PostMapping
	public ResponseEntity<Users> registerUser(@RequestBody Users u) {
		
		return new ResponseEntity<Users>(us.registerUser(u), HttpStatus.CREATED);
	}
	
	/*
	 * 
	 * To do : add findAllFavoriteDrinks
	 * 
	 */

}
