package com.mixology.services;

import java.util.ArrayList;
import java.util.List;

import com.mixology.models.Recipes;
import com.mixology.repositories.IngredientsDAO;
import com.mixology.repositories.RecipesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mixology.models.Drinks;
import com.mixology.models.Ingredients;
import com.mixology.models.Users;
import com.mixology.repositories.DrinksDAO;

@Service
public class DrinkServiceImpl implements DrinkService {

    private DrinksDAO dd;
    private IngredientsDAO ingredientsDAO;
    private RecipesDAO recipesDAO;

    @Autowired
    public DrinkServiceImpl(DrinksDAO dd, IngredientsDAO ingredientsDAO, RecipesDAO recipesDAO) {
        this.dd = dd;
        this.ingredientsDAO = ingredientsDAO;
        this.recipesDAO = recipesDAO;
    }

    @Override
    public List<Drinks> findAllDrinks() {
        return dd.findAll();
    }

    @Override
    public Drinks findDrinkById(int id) {
        return dd.getOne(id);
    }

    @Override
    public Drinks saveDrink(Drinks d) {
    	dd.save(d); 
    	int userId = d.getDrinkCreator().getId();
    	updateDrinkCreator(userId, d.getId());
    	dd.flush();
    	//return dd.saveAndFlush(d);
    	return d;
    }

    public void updateDrinkCreator(int userId, int drinkId) {
    	//System.out.println("user: " + userId + " drinkId: " + drinkId);
    	dd.updateDrinkCreator(userId, drinkId);
    }
    
    @Override
    public Drinks findDrinksByName(String name) {
        return dd.findDrinksByNameIgnoreCase(name);
    }

    @Override
    public List<Drinks> findByCreator(Users u) {

        return dd.findDrinksByDrinkCreator(u);
    }

    @Override
    public List<Drinks> findDrinksByDegree(int degree) {
        return dd.findDrinksByDegree(degree);
    }

    @Override
    public List<Drinks> findDrinksByIngredientName(String ingredientName) {
        List<Recipes> recipes = new ArrayList<>();
        List<Drinks> drinks = new ArrayList<>();
        int ingredientId = ingredientsDAO.getIngredientsByNameIgnoreCase(ingredientName).getId();

        recipesDAO.findRecipesByIngredientId(ingredientId).forEach(recipes::add);

        for (int i = 0; i < recipes.size(); i++) {
            drinks.add(recipes.get(i).getDrink());
        }
        return drinks;
    }
    
  

}
