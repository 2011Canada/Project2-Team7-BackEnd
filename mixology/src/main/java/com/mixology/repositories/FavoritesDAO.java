package com.mixology.repositories;

import java.util.List;

import com.mixology.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Favorites;

public interface FavoritesDAO extends JpaRepository<Favorites, Users>{
	
	// public List<Integer> findAllDrinkIdByUserId(int userId);

}
