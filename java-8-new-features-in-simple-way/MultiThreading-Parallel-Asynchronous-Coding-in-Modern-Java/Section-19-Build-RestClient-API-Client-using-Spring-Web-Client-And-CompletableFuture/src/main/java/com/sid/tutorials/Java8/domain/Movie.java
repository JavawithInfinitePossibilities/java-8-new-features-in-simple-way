/**
 * 
 */
package com.sid.tutorials.Java8.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	private MovieInfo movieInfo;
    private List<Review> reviewList;
}
