package com.mixology.services;

import java.util.List;

import com.mixology.models.Drinks;
import com.mixology.models.Users;

public interface DrinkService {
	
	
	  public List<Drinks> findAllDrinks();

	    public Drinks findDrinkById(int id);

	    public Drinks saveDrink(Drinks d);

	    public Drinks findDrinksByName(String name);
	    
	    public Drinks findByCreator(Users u);
	    
	    public Drinks findDrinksByDegree(int degree);
	    
	    public List<Drinks> findDrinksByIngredientName(String ingredientName);
	    
}
