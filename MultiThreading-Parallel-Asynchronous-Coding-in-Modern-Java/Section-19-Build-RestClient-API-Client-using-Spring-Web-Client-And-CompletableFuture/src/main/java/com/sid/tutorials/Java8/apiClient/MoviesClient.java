/**
 * 
 */
package com.sid.tutorials.Java8.apiClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.sid.tutorials.Java8.domain.Movie;
import com.sid.tutorials.Java8.domain.MovieInfo;
import com.sid.tutorials.Java8.domain.Review;

/**
 * @author kunmu
 *
 */
public class MoviesClient {
	private final WebClient webClient;

	public MoviesClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public Movie retrieveMovie(Long movieInfoId) {
		MovieInfo movieInfo = invokeMovieInfoService(movieInfoId);
		List<Review> reviews = invokeReviewsService(movieInfoId);
		return new Movie(movieInfo, reviews);
	}

	private List<Review> invokeReviewsService(Long movieInfoId) {
		String uri = UriComponentsBuilder.fromUriString("/v1/reviews").queryParam("movieInfoId", movieInfoId)
				.buildAndExpand().toUriString();
		List<Review> reviews = webClient.get().uri(uri).retrieve().bodyToFlux(Review.class).collectList().block();
		return reviews;
	}

	private MovieInfo invokeMovieInfoService(Long movieInfoId) {
		var movieInfoUrlPath = "/v1/movie_infos/{movieInfoId}";
		MovieInfo movieInfo = webClient.get().uri(movieInfoUrlPath, movieInfoId).retrieve().bodyToMono(MovieInfo.class)
				.block();
		return movieInfo;
	}

	public CompletableFuture<Movie> retrieveMovie_CF(Long movieInfoId) {
		CompletableFuture<MovieInfo> movieInfo = CompletableFuture
				.supplyAsync(() -> invokeMovieInfoService(movieInfoId));
		CompletableFuture<List<Review>> reviews = CompletableFuture
				.supplyAsync(() -> invokeReviewsService(movieInfoId));
		return movieInfo.thenCombine(reviews, (movieInfoResult, reviewsResult) -> {
			return new Movie(movieInfoResult, reviewsResult);
		});
	}

	public List<Movie> retrieveMovieList(List<Long> movieInfoIds) {
		return movieInfoIds.stream().parallel().map(movieInfoId -> retrieveMovie(movieInfoId))
				.collect(Collectors.toList());
	}

	public List<Movie> retrieveMovieList_CF(List<Long> movieInfoIds) {
		List<CompletableFuture<Movie>> movieFutures = movieInfoIds.stream().parallel()
				.map(movieInfoId -> retrieveMovie_CF(movieInfoId)).collect(Collectors.toList());
		return movieFutures.stream().map(movieFutureCF -> movieFutureCF.join()).collect(Collectors.toList());
	}
}
