package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.Review;
import com.example.cs4550criticalprojectionsserverjava.repositories.CommentRepository;
import com.example.cs4550criticalprojectionsserverjava.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

@Service
public class ReviewService {
  @Autowired
  ReviewRepository reviewRepository;
  List<Review> reviews = new ArrayList<>();
  {
    reviews.add(new Review(-1, "tt0120338", -1, 6, "Boooooringgggg", "Gosh this was pretty bad. " +
            "I'm really glad that they can't make a sequel.", 360, true, false));
    reviews.add(new Review(-2, "tt0120338", -2, 10, "Heartbreaking and Life-Changing",
            "This made me cry so hard.  I hardly ever get emotional but this masterpiece moved me to tears. " +
                    "I was really moved by the tragic tale of that poor, beautiful ship.  Oh, and some people died too.",
            22, true, false));
    reviews.add(new Review(-3, "tt0120338", -3, 1, "This isn't G-Force",
            "I went to the theater expecting some crazy guinea pig spy action. Imagine my disappointment " +
                    "when I took my seat only to be greeted by some sob story about a boat. Would give a negative rating if I could.",
            1000, true, false));
    reviews.add(new Review(-4, "tt0120338", -4, 8, "I didn't even watch",
            "I'm a critic so I know that you will trust me even though I slept through it all.",
            10000, true, true));
  }

  public List<Review> findCriticReviewsForMovie(String mid, Integer count) {
    List<Review> reviewsForMovie = this.reviewRepository.findCriticReviewByMovie(mid);
    if (count < reviewsForMovie.size()) {
      return reviewsForMovie.subList(0, count);
    }
    return reviewsForMovie;
  }

  public List<Review> getReviews(Integer count) {
    List<Review> reviewsForMovie = (List<Review>)this.reviewRepository.findAll();
    if (count < reviewsForMovie.size()) {
      return reviewsForMovie.subList(0, count);
    }
    return reviewsForMovie;
  }

  public List<Review> findUserReviewsForMovie(String mid, Integer count) {
    List<Review> reviewsForMovie = this.reviewRepository.findUserReviewByMovie(mid);
    if (count < reviewsForMovie.size()) {
      return reviewsForMovie.subList(0, count);
    }
    return reviewsForMovie;
  }

  public List<Review> findReviewsForMovie(String mid, Integer count) {
    List<Review> reviewsForMovie = this.reviewRepository.findReviewByMovie(mid);
    if (count < reviewsForMovie.size()) {
      return reviewsForMovie.subList(0, count);
    }
    return reviewsForMovie;
  }

  public List<Review> findReviewsForUser(Integer uid) {
    return this.reviewRepository.findReviewByUser(uid);
  }

  public List<Review> findTopReviews(Integer count) {
    List<Review> reviews = this.reviewRepository.findTopReviews();
    if (count < reviews.size()) {
      return reviews.subList(0, count);
    }
    return reviews;
  }

  public Review createReview(Review review) {
    return reviewRepository.save(review);
  }

  public Integer removeReview(Integer reviewId) {
    reviewRepository.deleteById(reviewId);
    return 0;
  }

  public Review updateReview(Integer reviewId, Review review) {
    Review r = reviewRepository.findById(reviewId).get();
    r.setApproved(review.getApproved());
    r.setBody(review.getBody());
    r.setLikes(review.getLikes());
    r.setTitle(review.getTitle());
    r.setRating(review.getRating());
    return reviewRepository.save(r);
  }

  public Double getScoreForMovie(String mid) {
    int sum = 0;
    int count = 0;

    for (Review r: this.findCriticReviewsForMovie(mid, Integer.MAX_VALUE)) {
      sum += r.getRating();
      count++;
    }
    for (Review r: this.findUserReviewsForMovie(mid, Integer.MAX_VALUE)) {
      sum += r.getRating();
      count++;
    }

    if (count == 0) {
      return 0.0;
    }
    double temp = (double)sum / (double)count;
    return  Math.floor(temp * 100) / 100;
  }
}
