package com.mixology.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mixology.models.Reviews;
import com.mixology.repositories.ReviewsDAO;
import com.mixology.repositories.UsersDAO;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

	private ReviewsDAO rd;
	
	@Autowired
    public ReviewServiceImpl(ReviewsDAO rd) {
    	this.rd = rd;
    }
	
	@Override
	public Reviews addReview(Reviews r) {
		return rd.saveAndFlush(r);
	}

	@Override
	public List<Reviews> findReviewsByDrinkId(int drinkId) {
		return rd.getReviewsByDrinkId(drinkId);
	}

	@Override
	public List<Reviews> findReviewsByRate(int rate) {
		return rd.getReviewsByRate(rate);
	}



}
