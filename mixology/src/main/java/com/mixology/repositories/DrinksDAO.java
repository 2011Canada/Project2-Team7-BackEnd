package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mixology.models.Drinks;
import com.mixology.models.Users;

import java.util.List;

import javax.transaction.Transactional;


public interface DrinksDAO  extends JpaRepository<Drinks, Integer>{
	
	public Drinks findDrinksByName(String name);
	
	public List<Drinks> findDrinksByDegree(int degree);

	public List<Drinks> findDrinksByDrinkCreator(Users u);
	
	@Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Drinks set drinkcreator = :userid where drinkid = :drinkid")
	public void updateDrinkCreator(@Param(value = "userid") int userid, @Param(value = "drinkid") int drinkid);
}
