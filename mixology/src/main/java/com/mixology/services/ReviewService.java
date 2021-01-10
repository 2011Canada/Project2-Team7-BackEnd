package com.mixology.services;

import com.mixology.models.Reviews;

import java.util.List;

public interface ReviewService {

	public Reviews addReview(Reviews r);

	public List<Reviews> findReviewsByDrinkId(int drinkId);

	public List<Reviews> findReviewsByRate(int rate);

}
