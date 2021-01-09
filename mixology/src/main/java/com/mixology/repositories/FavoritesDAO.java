package com.mixology.repositories;

import java.util.List;
import java.util.Set;

import com.mixology.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoritesDAO extends JpaRepository<Favorites, Users>{
	public List<Favorites> findByUserId(int userId);
}
