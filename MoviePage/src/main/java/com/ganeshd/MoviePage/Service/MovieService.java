package com.ganeshd.MoviePage.Service;

import com.ganeshd.MoviePage.Repository.MovieRepository;
import com.ganeshd.MoviePage.model.Movie;
import com.ganeshd.MoviePage.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepo;
    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }


    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepo.findByimdbId(imdbId);
    }

    public Movie saveMovie(Movie movie) {
        Optional<Movie> existingMovie = movieRepo.findByimdbId(movie.getImdbId());
        if (existingMovie.isPresent()) {
            throw new DuplicateImdbIdException("Movie with IMDb ID " + movie.getImdbId() + " already exists.");
        }
        return movieRepo.save(movie);
    }

    public List<Review> getReviewsByImdbId(String imdbId) {
        Movie movie = movieRepo.findByImdbId(imdbId);
        if (movie != null) {
            return movie.getReviews(); // Return the associated reviews
        } else {
            return Collections.emptyList(); // No movie found
        }
    }
}
