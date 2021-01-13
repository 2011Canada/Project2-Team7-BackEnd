package com.mixology.services;

import java.util.List;

import com.mixology.models.Drinks;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipes;

public interface IngredientService {
	
	 public List<Ingredients> findAllIngredients();
	
	 public List<Ingredients> findIngredientsByDrinkId(int drinkId);
	 
	 public Recipes saveRecipe(Recipes r);
	 
	 public Ingredients saveIngredient(Ingredients i);
}
