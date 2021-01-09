package com.mixology.services;

import java.util.List;

import com.mixology.models.Drinks;
import com.mixology.models.Users;

public interface UserService {
	
	   
	public List<Users> findAllUsers();
	    
    public Users findUsersByUsernameAndPassword(String username, String password);
    
    public Users findUsersById(int id);
    
    public Users registerUser(Users u);
    
 //   public List<Drinks> findAllFavoriteDrinks(int userId);
    
//    public Users findUsersByUsername(String username) ;
//  
//    public Users findUsersByPassword(String username);
    
    

    

}
