package com.mixology.services;

import com.mixology.models.Reviews;

public interface ReviewService {
	
	
	//public Reviews addReview(int userId, int drinkId, String desc, int rate);
	public Reviews addReview(Reviews r);

}
