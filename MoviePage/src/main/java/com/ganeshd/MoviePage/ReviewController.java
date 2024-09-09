package com.ganeshd.MoviePage;

import com.ganeshd.MoviePage.Service.ReviewService;
import com.ganeshd.MoviePage.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("reviewapp/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("body"), payload.get("imdbId")), HttpStatus.CREATED);
    }

}
