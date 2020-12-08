package com.dilip.movierating.bean;

import java.util.List;

public class RatingList {

	private List<Rating> ratingList;

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
