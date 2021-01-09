package com.mixology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixology.models.Reviews;
import com.mixology.repositories.ReviewsDAO;
import com.mixology.repositories.UsersDAO;

@Service
public class ReviewServiceImpl implements ReviewService{

	private ReviewsDAO rd;
	
	@Autowired
    public ReviewServiceImpl(ReviewsDAO rd) {
    	this.rd = rd;
    }
	
	@Override
	//public Reviews addReview(int userId, int drinkId, String desc, int rate) {
	public Reviews addReview(Reviews r) {
		
		return rd.saveAndFlush(r);
	}

	
}
