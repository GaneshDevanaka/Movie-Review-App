package com.ganeshd.MoviePage.Repository;

import com.ganeshd.MoviePage.model.Movie;
import com.ganeshd.MoviePage.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
