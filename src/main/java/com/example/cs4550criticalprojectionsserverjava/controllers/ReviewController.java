package com.example.cs4550criticalprojectionsserverjava.controllers;

import com.example.cs4550criticalprojectionsserverjava.models.Review;
import com.example.cs4550criticalprojectionsserverjava.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {
  @Autowired
  ReviewService service;

  @GetMapping("/api/movies/{mid}/reviews/{cnt}")
  public List<Review> findReviewsForMovie(
          @PathVariable("mid") String movieId,
          @PathVariable("cnt") Integer count) {
    return service.findReviewsForMovie(movieId, count);
  }

  @GetMapping("/api/movies/{mid}/reviews/critic/{cnt}")
  public List<Review> findCriticReviewsForMovie(
          @PathVariable("mid") String movieId,
          @PathVariable("cnt") Integer count) {
    return service.findCriticReviewsForMovie(movieId, count);
  }

  @GetMapping("/api/movies/{mid}/reviews/user/{cnt}")
  public List<Review> findUserReviewsForMovie(
          @PathVariable("mid") String movieId,
          @PathVariable("cnt") Integer count) {
    return service.findUserReviewsForMovie(movieId, count);
  }

  @GetMapping("/api/reviews/{cnt}")
  public List<Review> findReviews(@PathVariable("cnt") Integer count) {
    return service.findTopReviews(count);
  }

  @GetMapping("/api/movies/{mid}/score")
  public Double findUserReviewsForMovie(@PathVariable("mid") String movieId) {
    return service.getScoreForMovie(movieId);
  }

  @GetMapping("/api/users/{uid}/reviews")
  public List<Review> findReviewsForUser(
          @PathVariable("uid") Integer userId) {
    return service.findReviewsForUser(userId);
  }

  @PostMapping("/api/reviews")
  public Review createReview(
          @RequestBody Review review) {
    return service.createReview(review);
  }

  @DeleteMapping("/api/reviews/{rid}")
  public Integer deleteReview(
          @PathVariable("rid") Integer reviewId) {
    return service.removeReview(reviewId);
  }

  @PutMapping("/api/reviews/{rid}")
  public Review updateReview(
          @PathVariable("rid") Integer reviewId,
          @RequestBody Review review) {
    return service.updateReview(reviewId, review);
  }
}
