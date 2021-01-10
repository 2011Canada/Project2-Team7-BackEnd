package com.mixology.repositories;

import com.mixology.models.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Reviews;

import java.util.List;

public interface ReviewsDAO extends JpaRepository<Reviews, Integer>{
    public List<Reviews> getReviewsByDrinkId(int id);
    public List<Reviews> getReviewsByRate(int rating);
}
