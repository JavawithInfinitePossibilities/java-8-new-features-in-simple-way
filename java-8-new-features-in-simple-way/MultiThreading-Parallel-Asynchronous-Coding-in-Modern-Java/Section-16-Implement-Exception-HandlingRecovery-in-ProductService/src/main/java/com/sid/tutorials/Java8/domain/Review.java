package com.sid.tutorials.Java8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Review {
    private int noOfReviews;
    private double overallRating;
}
