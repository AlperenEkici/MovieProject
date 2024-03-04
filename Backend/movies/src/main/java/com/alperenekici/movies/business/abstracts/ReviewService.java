package com.alperenekici.movies.business.abstracts;

import com.alperenekici.movies.Entities.Review;

public interface ReviewService {
    public Review createReview(String reviewBody, String imdbId);
}
