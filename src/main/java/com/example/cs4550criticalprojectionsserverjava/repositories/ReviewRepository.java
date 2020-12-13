package com.example.cs4550criticalprojectionsserverjava.repositories;

import com.example.cs4550criticalprojectionsserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

  @Query(value = "SELECT * FROM reviews where movie_id=:mid AND critic_review = true ORDER BY likes DESC", nativeQuery = true)
  public List<Review> findCriticReviewByMovie(
          @Param("mid") String movieId
  );

  @Query(value = "SELECT * FROM reviews where movie_id=:mid AND critic_review = false ORDER BY likes DESC", nativeQuery = true)
  public List<Review> findUserReviewByMovie(
          @Param("mid") String movieId
  );

  @Query(value = "SELECT * FROM reviews where movie_id=:mid ORDER BY likes DESC", nativeQuery = true)
  public List<Review> findReviewByMovie(
          @Param("mid") String movieId
  );

  @Query(value = "SELECT * FROM reviews ORDER BY likes DESC", nativeQuery = true)
  public List<Review> findTopReviews();

  @Query(value = "SELECT * FROM reviews where user_id=:uid ORDER BY likes DESC", nativeQuery = true)
  public List<Review> findReviewByUser(
          @Param("uid") Integer userId
  );
}
