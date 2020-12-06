package com.example.cs4550criticalprojectionsserverjava.services;

import com.example.cs4550criticalprojectionsserverjava.models.Comment;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class CommentService {
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

  public List<Comment> findCommentsForReview(Integer rid) {
    List<Comment> commentsForReview = new ArrayList<>();
    for (Comment c: comments) {
      if (rid == c.getReviewId()) {
        commentsForReview.add(c);
      }
    }
    return commentsForReview;
  }

  public List<Comment> findCommentsForUser(Integer uid) {
    List<Comment> commentsForUser = new ArrayList<>();
    for (Comment c: comments) {
      if (uid == c.getUserId()) {
        commentsForUser.add(c);
      }
    }
    return commentsForUser;
  }

  public Comment createComment(Comment comment) {
    Integer newId = (new Random()).nextInt(Integer.MAX_VALUE);
    comment.setId(newId);
    comments.add(comment);
    return comment;
  }

  public Integer removeComment(Integer commentId) {
    for (Comment c: comments) {
      if (commentId == c.getId()) {
        comments.remove(c);
      }
    }
    return 0;
  }

  public Integer updateComment(Integer commentId, Comment comment) {
    for (int ii = 0; ii < comments.size(); ii++) {
      if (comments.get(ii).getId() == commentId) {
        comments.set(ii, comment);
      }
    }
    return 0;
  }
}
