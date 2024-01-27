package com.sid.tutorials.Java8;

import static com.sid.tutorials.Java8.util.CommonUtil.startTime;
import static com.sid.tutorials.Java8.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.sid.tutorials.Java8.apiClient.MoviesClient;
import com.sid.tutorials.Java8.domain.Movie;
import com.sid.tutorials.Java8.util.CommonUtil;

class Section19BuildRestClientAPIClientusingSpringWebClientAndCompletableFutureTest {

	WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080/movies").build();
	MoviesClient moviesClient = new MoviesClient(webClient);

	@Disabled
	@Test
	/* @RepeatedTest(10) */
	void retrieveMovie() {
		startTime(true);
		// given
		var movieInfoId = 1L;
		// when
		Movie movie = moviesClient.retrieveMovie(movieInfoId);
		System.out.println("Value : " + movie);
		// then
		assert movie != null;
		assertEquals("Batman Begins", movie.getMovieInfo().getName());
		assert movie.getReviewList().size() == 1;
		timeTaken();
	}

	@Disabled
	@Test
	/* @RepeatedTest(10) */
	void retrieveMovie_CF() {
		// given
		var movieInfoId = 1L;

		// when
		startTime(true);
		var movie = moviesClient.retrieveMovie_CF(movieInfoId).join();
		CommonUtil.timeTaken();
		// then
		assert movie != null;
		assertEquals("Batman Begins", movie.getMovieInfo().getName());
		assert movie.getReviewList().size() == 1;

	}

	@Test
	void retrieveMovieList() {
		// given
		List<Long> movieInfoIds = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L);
		// when
		startTime(true);
		List<Movie> movies = moviesClient.retrieveMovieList(movieInfoIds);
		System.out.println("retrieveMovieList movies : " + movies);
		CommonUtil.timeTaken();
		// then
		assert movies.size() == 7;
	}

	@Test
	void retrieveMovieList_CF() {
		// given
		List<Long> movieInfoIds = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L);
		// when
		startTime(true);
		List<Movie> movies = moviesClient.retrieveMovieList_CF(movieInfoIds);
		System.out.println("retrieveMovieList_CF movies : " + movies);
		CommonUtil.timeTaken();
		// then
		assert movies.size() == 7;
	}
}
