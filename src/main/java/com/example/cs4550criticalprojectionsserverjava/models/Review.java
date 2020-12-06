package com.example.cs4550criticalprojectionsserverjava.models;

// @Entity
// @Table(name = 'reviews')
public class Review{
  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String movieId;
  private String userId;
  private Integer rating;
  private String body;
  private Integer likes;
  private Boolean approved;

  public Review(Integer id, String movieId, String userId, Integer rating, String body, Integer likes,
                Boolean approved) {
    this.id = id;
    this.movieId = movieId;
    this.userId = userId;
    this.rating = rating;
    this.body = body;
    this.likes = likes;
    this.approved = approved;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
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

  public Boolean getApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }
}
