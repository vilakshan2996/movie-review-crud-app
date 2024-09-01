package com.example.movie_review.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movie_review")
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String review;
    private String reviewer;
    private int rating; // Rating out of 10
}

