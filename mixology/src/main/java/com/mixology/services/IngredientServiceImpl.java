package com.mixology.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mixology.models.Drinks;
import com.mixology.models.Ingredients;
import com.mixology.models.Recipes;
import com.mixology.repositories.DrinksDAO;
import com.mixology.repositories.IngredientsDAO;
import com.mixology.repositories.RecipesDAO;

@Service
public class IngredientServiceImpl implements IngredientService{

	    private RecipesDAO recipesDAO;
	    private IngredientsDAO ingredientsDAO;
	    
	    @Autowired
	    public IngredientServiceImpl( IngredientsDAO ingredientsDAO, RecipesDAO recipesDAO) {
	        this.recipesDAO = recipesDAO;
	        this.ingredientsDAO = ingredientsDAO;
	    }
	    
	    @Override
	    public List<Ingredients> findAllIngredients() {
	        return ingredientsDAO.findAll();
	    }
	    
	    @Override
	    public List<Ingredients> findIngredientsByDrinkId(int drinkId){
	    	List<Recipes> recipes = new ArrayList<>();
	        List<Ingredients> ingredients = new ArrayList<>();

	        recipesDAO.findRecipesByDrinkId(drinkId).forEach(recipes::add);
	        for (int i = 0; i < recipes.size(); i++) {
	        	ingredients.add(recipes.get(i).getIngredient());
	        }
	        return ingredients;
	    }
	   
	    @Override
	    public Recipes saveRecipe(Recipes r) {
	    	
	        //return recipesDAO.saveAndFlush(r);
	    	
	        Recipes rObj = recipesDAO.save(r);
	        int drinkId = rObj.getDrink().getId();
	        int ingId = rObj.getIngredient().getId();
	        updateRecipes(drinkId, ingId, drinkId, ingId);
	        //System.out.println("drinkId = " + drinkId);
	        //System.out.println("ingId = " + ingId);
	        int recipeId = findRecipeId(drinkId, ingId);
	        //System.out.println("recipeId = " + recipeId);
	        
	        recipesDAO.flush();
	       
	        return rObj;
	        
	        
	       
	    }
	    public int findRecipeId(int drinkid, int ingid) {
	    	System.out.println("findRecipeId");
	    	return recipesDAO.findRecipeIdByDrinkIdAndIngId(drinkid, ingid);
        }
	    
	    public void updateRecipes(int drinkid, int ingid, int drink_id, int ing_id) {
	    	recipesDAO.updateRecipes(drinkid, ingid, drink_id, ing_id);
        }
	    
	    @Override
	    public Ingredients saveIngredient(Ingredients i) {
	        return ingredientsDAO.saveAndFlush(i);
	    }
	    
	   
}
