package com.mixology.services;

import java.util.List;

import com.mixology.models.Drinks;
import com.mixology.models.Ingredients;
import com.mixology.models.Users;

public interface DrinkService {
	
	
	  public List<Drinks> findAllDrinks();

	  public Drinks findDrinkById(int id);

	  public Drinks saveDrink(Drinks d);

	  public Drinks findDrinksByName(String name);
	    
	  public List<Drinks> findByCreator(Users u);
	    
	  public List<Drinks> findDrinksByDegree(int degree);
	    
	  public List<Drinks> findDrinksByIngredientName(String ingredientName);
	  
	  public List<Ingredients> findIngredientsByDrinkId(int drinkId);
	    
}
