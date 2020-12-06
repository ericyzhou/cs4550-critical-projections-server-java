package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.Review;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ReviewService {
  List<Review> reviews = new ArrayList<>();
  {
    reviews.add(new Review(-1, "tt0120338", -1, 6, "Boooooringgggg", "Gosh this was pretty bad." +
            "I'm really glad that they can't make a sequel.", 360, true, false));
    reviews.add(new Review(-2, "tt0120338", -2, 10, "Heartbreaking and Life-Changing",
            "This made me cry so hard.  I hardly ever get emotional but this masterpiece moved me to tears." +
                    "I was really moved by the tragic tale of that poor, beautiful ship.  Oh, and some people died too.",
            22, true, false));
    reviews.add(new Review(-3, "tt0120338", -3, 1, "This isn't G-Force",
            "I went to the theater expecting some crazy guinea pig spy action. Imagine my disappointment " +
                    "when I took my seat only to be greeted by some sob story about a boat. Would give a negative rating if I could.",
            1000, true, false));
  }

  public List<Review> findReviewsForMovie(String mid) {
    List<Review> reviewsForMovie = new ArrayList<>();
    for (Review r: reviews) {
      if (r.getMovieId().equals(mid)) {
        reviewsForMovie.add(r);
      }
    }
    return reviewsForMovie;
  }

  public List<Review> findReviewsForUser(Integer uid) {
    List<Review> reviewsForMovie = new ArrayList<>();
    for (Review r: reviews) {
      if (r.getUserId() == uid) {
        reviewsForMovie.add(r);
      }
    }
    return reviewsForMovie;
  }

  public Review createReview(Review review) {
    Integer newId = (new Random()).nextInt(Integer.MAX_VALUE);
    review.setId(newId);
    reviews.add(review);
    return review;
  }

  public Integer removeReview(Integer reviewId) {
    for (Review r: reviews) {
      if (reviewId == r.getId()) {
        reviews.remove(r);
      }
    }
    return 0;
  }

  public Integer updateReview(Integer reviewId, Review review) {
    for (int ii = 0; ii < reviews.size(); ii++) {
      if (reviews.get(ii).getId() == reviewId) {
        reviews.set(ii, review);
      }
    }
    return 0;
  }
}
