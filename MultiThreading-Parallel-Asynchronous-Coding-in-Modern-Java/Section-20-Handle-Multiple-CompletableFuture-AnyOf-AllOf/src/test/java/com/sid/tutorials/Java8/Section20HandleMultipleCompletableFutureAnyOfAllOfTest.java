package com.sid.tutorials.Java8;

import static com.sid.tutorials.Java8.util.CommonUtil.startTime;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import com.sid.tutorials.Java8.apiClient.MoviesClient;
import com.sid.tutorials.Java8.util.CommonUtil;

class Section20HandleMultipleCompletableFutureAnyOfAllOfTest {
	WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080/movies").build();
	MoviesClient moviesClient = new MoviesClient(webClient);

	@Test
	void retrieveMovieList_CF_approach2() {
		// given
		var movieInfoIds = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L);

		// when
		startTime(true);
		/* var movies = moviesClient.retrieveMovieList_CF_allOf(movieInfoIds); */
		var movies = moviesClient.retrieveMovieList_CF_anyOf(movieInfoIds);

		System.out.println("movies : " + movies);
		CommonUtil.timeTaken();
		// then
		assert movies.size() == 7;

	}

}
