package com.mixology.controllers;
import java.util.List;

import com.mixology.models.Drinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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
	
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<Users> findUsersByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
		return new ResponseEntity<Users>(us.findUsersByUsernameAndPassword(username, password), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> findUsersById(@PathVariable int id) {
		ResponseEntity result = new ResponseEntity<>(us.findUsersById(id), HttpStatus.OK);
		return  result;
	}
	
	@PostMapping
	public ResponseEntity<Users> registerUser(@RequestBody Users u) {
		return new ResponseEntity<Users>(us.registerUser(u), HttpStatus.CREATED);
	}

	@GetMapping("/favoriteDrinks/{userId}")
	public ResponseEntity<List<Drinks>> findAllFavoriteDrinks(@PathVariable int userId){
		return new ResponseEntity<List<Drinks>>(us.findAllFavoriteDrinks(userId),HttpStatus.OK);
	}


}
