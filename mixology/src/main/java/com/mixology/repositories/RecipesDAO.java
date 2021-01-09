package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Recipes;

public interface RecipesDAO extends JpaRepository<Recipes, Integer>{

}
