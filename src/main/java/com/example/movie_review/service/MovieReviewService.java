package com.example.movie_review.service;


import com.example.movie_review.model.MovieReview;
import com.example.movie_review.repository.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewService {

    @Autowired
    private MovieReviewRepository repository;

    public List<MovieReview> getAllReviews() {
        return repository.findAll();
    }

    public MovieReview getReviewById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MovieReview addReview(MovieReview review) {
        return repository.save(review);
    }

    public MovieReview updateReview(Long id, MovieReview review) {
        MovieReview existingReview = repository.findById(id).orElse(null);
        if (existingReview != null) {
            existingReview.setTitle(review.getTitle());
            existingReview.setReview(review.getReview());
            existingReview.setReviewer(review.getReviewer());
            existingReview.setRating(review.getRating());
            return repository.save(existingReview);
        }
        return null;
    }

    public void deleteReview(Long id) {
        repository.deleteById(id);
    }
}
