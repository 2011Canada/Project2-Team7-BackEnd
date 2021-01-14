package com.mixology.repositories;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.mixology.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.mixology.models.Favorites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FavoritesDAO extends JpaRepository<Favorites, Users>{
	public List<Favorites> findByUserId(int userId);

	@Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Favorites set drink_drinkid = :drinkid, user_userid = :userid where favoriteid = :favId")
	public void updateFavorites(@Param(value = "drinkid") int drinkid, @Param(value = "userid") int userid, @Param(value = "favId") int favId);
}
