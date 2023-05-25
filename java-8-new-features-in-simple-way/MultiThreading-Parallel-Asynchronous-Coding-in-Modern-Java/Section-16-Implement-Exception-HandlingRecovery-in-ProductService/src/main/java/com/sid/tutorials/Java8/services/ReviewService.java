package com.sid.tutorials.Java8.services;

import com.sid.tutorials.Java8.domain.Review;
import com.sid.tutorials.Java8.util.CommonUtil;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        CommonUtil.delay(1000);
        Review review=new Review(200, 4.5);
        return review;
    }
}
