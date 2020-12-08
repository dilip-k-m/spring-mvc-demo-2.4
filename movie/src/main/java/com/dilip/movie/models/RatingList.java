package com.dilip.movie.models;

import java.util.List;

import com.dilip.movie.model.Rating;

public class RatingList {

	private List<Rating> ratingList;

	public RatingList() {
		
	}
	public RatingList(List<Rating> ratingList) {
		super();
		this.ratingList = ratingList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	@Override
	public String toString() {
		return "RatingList [ratingList=" + ratingList + "]";
	}
	
}
