package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mixology.models.Drinks;
import com.mixology.models.Users;

import java.util.List;


public interface DrinksDAO  extends JpaRepository<Drinks, Integer>{
	
	public Drinks findDrinksByName(String name);
	
	public List<Drinks> findDrinksByDegree(int degree);

	public List<Drinks> findDrinksByDrinkCreator(Users u);
	
}
