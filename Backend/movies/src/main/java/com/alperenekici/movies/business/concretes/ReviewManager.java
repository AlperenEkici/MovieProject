package com.alperenekici.movies.business.concretes;

import com.alperenekici.movies.DataAccess.ReviewDao;
import com.alperenekici.movies.Entities.Movie;
import com.alperenekici.movies.Entities.Review;
import com.alperenekici.movies.business.abstracts.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewManager implements ReviewService {
    ReviewDao reviewDao;

    @Autowired
    public ReviewManager(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }


    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewDao.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
