package com.example.movie_review.controller;

import com.example.movie_review.model.MovieReview;
import com.example.movie_review.service.MovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class MovieReviewController {

    @Autowired
    private MovieReviewService service;

    @GetMapping
    public List<MovieReview> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieReview> getReviewById(@PathVariable Long id) {
        MovieReview review = service.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MovieReview> addReview(@RequestBody MovieReview review) {
        MovieReview createdReview = service.addReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieReview> updateReview(@PathVariable Long id, @RequestBody MovieReview review) {
        MovieReview updatedReview = service.updateReview(id, review);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
