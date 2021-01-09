package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mixology.models.Drinks;
import com.mixology.models.Users;


public interface DrinksDAO  extends JpaRepository<Drinks, Integer>{
	
	public Drinks findDrinksByName(String name);
	
	public Drinks findDrinksByDegree(int degree);

	public Drinks findDrinksByDrinkCreator(Users u);
	
}
