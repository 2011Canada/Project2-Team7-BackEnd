package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Ingredients;

public interface IngredientsDAO extends JpaRepository<Ingredients, Integer>{

}
