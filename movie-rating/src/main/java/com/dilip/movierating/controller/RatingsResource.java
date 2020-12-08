package com.dilip.movierating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.movierating.bean.Rating;
import com.dilip.movierating.bean.RatingList;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

//	@GetMapping("/{movieId}")
//	public Rating getMovieRatingByMovId(@PathVariable("movieId") String movieId) {
//
//		return new Rating(movieId, 999);
//	}

	@GetMapping("/{userid}")
	public RatingList getMovieRatingByUserId(@PathVariable("userid") String userid) {
		
		List<Rating> ratingList = Arrays.asList(new Rating("RmovieId-1", 1), new Rating("RmovieId-2", 2),
				new Rating("RmovieId-3", 3), new Rating("RmovieId-4", 4));
		
		RatingList ratlst = new RatingList(ratingList);
		return ratlst;
	}

//	phase-1
//	@GetMapping("/{movieId}")
//	public Rating getMovieRatingByUserId(@PathVariable("movieId") String movieId) {
//
//		return new Rating(movieId, 999);
//	}
}
