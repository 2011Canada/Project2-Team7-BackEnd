package com.mixology.repositories;

import com.mixology.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Recipes;

import java.util.List;

public interface RecipesDAO extends JpaRepository<Recipes, Ingredients>{
    public List<Recipes> findRecipesByIngredientId(int ingredientId);
}
