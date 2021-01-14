package com.mixology.repositories;

import com.mixology.models.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mixology.models.Reviews;

import java.util.List;

import javax.transaction.Transactional;

public interface ReviewsDAO extends JpaRepository<Reviews, Integer>{
    public List<Reviews> getReviewsByDrinkId(int id);
    public List<Reviews> getReviewsByRate(int rating);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Reviews set userid = :userid , drinkid = :drinkid where reviewid = :reviewid")
    public void updateReviews(@Param(value = "userid") int userid, @Param(value = "drinkid") int drinkid, @Param(value = "reviewid") int reviewid );
}
 