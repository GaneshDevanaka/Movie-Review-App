package com.ganeshd.MoviePage;

import com.ganeshd.MoviePage.Service.DuplicateImdbIdException;
import com.ganeshd.MoviePage.Service.MovieService;
import com.ganeshd.MoviePage.model.Movie;
import com.ganeshd.MoviePage.model.Review;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("reviewapp/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getsingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie savedMovie = movieService.saveMovie(movie);
            return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
        } catch (DuplicateImdbIdException e) {
            throw e;
        }

    }
    @GetMapping("/{imdbId}/reviews")
    public ResponseEntity<List<Review>> getReviewsForMovie(@PathVariable String imdbId) {
        List<Review> reviews = movieService.getReviewsByImdbId(imdbId);
        if (!reviews.isEmpty()) {
            return ResponseEntity.ok(reviews);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
