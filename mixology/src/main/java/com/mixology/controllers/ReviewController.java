package com.mixology.controllers;

import com.mixology.models.Reviews;
import com.mixology.services.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping("/{drinkId}")
    public ResponseEntity<List<Reviews>> findReviewsByDrinkId(@PathVariable int drinkId){
        return new ResponseEntity<List<Reviews>>(reviewService.findReviewsByDrinkId(drinkId), HttpStatus.OK);
    }

    @GetMapping("/rating/{rate}")
    public ResponseEntity<List<Reviews>> findReviewsByRating(@PathVariable int rate){
        return new ResponseEntity<List<Reviews>>(reviewService.findReviewsByRate(rate), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reviews> addReview(@RequestBody Reviews reviews){
        return new ResponseEntity<Reviews>(reviewService.addReview(reviews), HttpStatus.OK);
    }
}
