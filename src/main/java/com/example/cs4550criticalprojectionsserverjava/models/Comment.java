package com.example.cs4550criticalprojectionsserverjava.models;

// @Entity
// @Table(name = 'comments')
public class Comment {
  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer reviewId;
  private Integer userId;
  private String body;
  private Integer likes;

  public Comment(Integer id, Integer reviewId, Integer userId, String body, Integer likes) {
    this.id = id;
    this.reviewId = reviewId;
    this.userId = userId;
    this.body = body;
    this.likes = likes;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getReviewId() {
    return reviewId;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }
}
