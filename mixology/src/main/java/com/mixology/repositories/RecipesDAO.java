package com.mixology.repositories;

import com.mixology.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mixology.models.Recipes;

import java.util.List;

import javax.transaction.Transactional;

public interface RecipesDAO extends JpaRepository<Recipes, Ingredients>{
    public List<Recipes> findRecipesByIngredientId(int ingredientId);
    public List<Recipes> findRecipesByDrinkId(int drinkId);
  
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Recipes set drinkid = :drinkid, ingid = :ingid, recipe_id = :recipeid where drink_drinkid = :drink_id and ingredient_ingid = :ing_id")
    public void updateRecipes(@Param(value = "drinkid") int drinkid, @Param(value = "ingid") int ingid, @Param(value = "recipeid") int recipeid, @Param(value = "drink_id") int drink_id, @Param(value = "ing_id") int ing_id);

    @Transactional
    @Query("from Recipes where drink_drinkid = :drinkid and ingredient_ingid = :ingid")
    public Recipes findRecipeIdByDrinkIdAndIngId(@Param(value = "drinkid") int drinkid, @Param(value = "ingid") int ingid);
}
