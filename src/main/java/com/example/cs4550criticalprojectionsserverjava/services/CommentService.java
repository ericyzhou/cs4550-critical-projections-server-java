package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.Comment;
import com.example.cs4550criticalprojectionsserverjava.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;

@Service
public class CommentService {
  @Autowired
  CommentRepository commentRepository;
  List<Comment> comments = new ArrayList<>();
  {
    comments.add(new Comment(-1, -1, -2, "How dare you say this! This movie is " +
            "prefect in every way! You probably are just a sad and lonely human who has never seen" +
            "anything beautiful so you don't know how to react to something that is!", -5));
    comments.add(new Comment(-2, -1, -3, "Wait you actually watched this? Wild.", 10));
    comments.add(new Comment(-3, -2, -1, "BAHAHAHA.  Yeah right. Someone paid " +
            "you to write this or you're James Cameron in disguise.", 30));
    comments.add(new Comment(-4, -3, -2, "Grow up.", -50));
  }

  public List<Comment> findCommentsForReview(Integer rid, Integer count) {
    List<Comment> commentsForReview = this.commentRepository.findCommentsByReview(rid);
    if (count < commentsForReview.size()) {
      return commentsForReview.subList(0, count);
    }
    return commentsForReview;
  }

  public List<Comment> findCommentsForUser(Integer uid) {
    return this.commentRepository.findCommentsByUser(uid);
  }

  public Comment createComment(Comment comment) {
    return commentRepository.save(comment);
  }

  public Integer removeComment(Integer commentId) {
    commentRepository.deleteById(commentId);
    return 0;
  }

  public Integer updateComment(Integer commentId, Comment comment) {
    Comment com = commentRepository.findById(commentId).get();
    com.setBody(comment.getBody());
    com.setLikes(comment.getLikes());
    commentRepository.save(com);
    return 0;
  }
}
