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
		rd.save(r); 
    	updateReview(r.getAuthor().getId(), r.getDrink().getId(), r.getId());
    	rd.flush();
    	
    	return r;
	}
	
	public void updateReview( int userId, int drinkId, int reviewId) {
    	rd.updateReviews(userId, drinkId, reviewId);
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
