package com.ganeshd.MoviePage.Service;

import com.ganeshd.MoviePage.Repository.ReviewRepository;
import com.ganeshd.MoviePage.model.Movie;
import com.ganeshd.MoviePage.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewrepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String body, String imdbId) {
        Review review = reviewrepository.insert(new Review(body, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review.getId()))
                .first();
        return review;
    }
}