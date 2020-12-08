package com.dilip.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.dilip.movie.model.CatalogItem;
import com.dilip.movie.model.CatalogItemList;
import com.dilip.movie.model.Movie;
import com.dilip.movie.model.Rating;
import com.dilip.movie.models.RatingList;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webclientBuilder;

	String movieInfoUri = "http://MOVIE-INFO-SERVICE/movie/";
	String ratingsdataUri = "http://MOVIE-RATING-SERVICE/ratingsdata/";

	@GetMapping("/{userId}")
	public CatalogItemList getuserMovieInfoByUserId(@PathVariable("userId") String userId) {

		RatingList ratings = (RatingList) prepWClient(webclientBuilder, ratingsdataUri + userId, RatingList.class);

		List<CatalogItem> catalogs = ratings.getRatingList().stream().map((Rating rating) -> {
//			Movie mov = restTemplate.getForObject( movieUriFunction + rating.getMovieId(), Movie.class);

			Movie mov = (Movie) prepWClient(webclientBuilder, movieInfoUri + rating.getMovieId(), Movie.class);

			return new CatalogItem(mov.getName(), mov.getName() + "-desc", rating.getRating());

		}).collect(Collectors.toList());

		CatalogItemList catList = new CatalogItemList(catalogs);
		return catList;

	}
//	phase-1
//	@GetMapping("/{userId}")
//	public List<CatalogItem> getuserMovieInfoByUserId(@PathVariable("userId") String userId) {
//		
//		return Collections.singletonList(
//				new CatalogItem(userId + "-movie1", "movie1-desc", 99)
//				);
//		
//	}

	public Object prepWClient(WebClient.Builder wcbuilder, String uriString, Class<?> clazz) {
		return wcbuilder.build().get().uri(uriString).retrieve().bodyToMono(clazz).block();
	}
}
