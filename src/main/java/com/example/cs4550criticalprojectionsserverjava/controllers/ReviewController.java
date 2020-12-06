package com.example.cs4550criticalprojectionsserverjava.controllers;

import com.example.cs4550criticalprojectionsserverjava.models.Review;
import com.example.cs4550criticalprojectionsserverjava.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {
  ReviewService service = new ReviewService();

  @GetMapping("/api/movies/{mid}/reviews")
  public List<Review> findReviewsForMovie(
          @PathVariable("mid") String movieId) {
    return service.findReviewsForMovie(movieId);
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
  public Integer deleteWidget(
          @PathVariable("rid") Integer reviewId) {
    return service.removeReview(reviewId);
  }

  @PutMapping("/api/reviews/{rid}")
  public Integer updateWidget(
          @PathVariable("rid") Integer reviewId,
          @RequestBody Review review) {
    return service.updateReview(reviewId, review);
  }
}
