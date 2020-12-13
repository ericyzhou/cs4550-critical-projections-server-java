package com.example.cs4550criticalprojectionsserverjava.repositories;

import com.example.cs4550criticalprojectionsserverjava.models.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

  @Query(value = "SELECT * FROM comments where review_id=:rid ORDER BY likes DESC", nativeQuery = true)
  public List<Comment> findCommentsByReview(
          @Param("rid") Integer reviewId
  );

  @Query(value = "SELECT * FROM comments where user_id=:uid ORDER BY likes DESC", nativeQuery = true)
  public List<Comment> findCommentsByUser(
          @Param("uid") Integer userId
  );
}
