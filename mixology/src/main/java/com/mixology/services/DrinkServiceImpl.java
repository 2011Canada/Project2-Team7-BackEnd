package com.mixology.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mixology.models.Drinks;
import com.mixology.models.Users;
import com.mixology.repositories.DrinksDAO;

@Service
public class DrinkServiceImpl implements DrinkService{

	private DrinksDAO dd;
	
	@Autowired
	public DrinkServiceImpl(DrinksDAO dd) {
		this.dd = dd;
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
		return dd.saveAndFlush(d);
	}

	@Override
	public Drinks findDrinksByName(String name) { return dd.findDrinksByName(name);	}

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
		return null;
	}

}
