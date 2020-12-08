package com.dilip.movieinfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.movieinfo.bean.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@GetMapping("/{movid}")
	public Movie getMovieById(@PathVariable("movid") String movieId) {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new Movie(movieId, movieId + "-name__");
	}

}
