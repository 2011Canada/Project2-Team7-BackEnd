package com.mixology.services;

import java.util.List;

import com.mixology.models.Ingredients;
import com.mixology.models.Recipes;

public interface IngredientService {
	
	 public List<Ingredients> findAllIngredients();
	
	 public List<Ingredients> findIngredientsByDrinkId(int drinkId);
	 
	 public Recipes saveRecipe(Recipes r);
	 
	 public Ingredients saveIngredient(Ingredients i);
	 
	 public int findRecipeId(int drinkid, int ingid);
	 
	 public void updateRecipes(int drinkid, int ingid, int drink_id, int ing_id);
}


