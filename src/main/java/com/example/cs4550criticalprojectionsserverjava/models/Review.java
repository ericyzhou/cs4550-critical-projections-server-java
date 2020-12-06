package com.example.cs4550criticalprojectionsserverjava.models;

// @Entity
// @Table(name = 'reviews')
public class Review{
  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String movieId;
  private Integer userId;
  private Integer rating;
  private String Title;
  private String Body;
  private Integer likes;
  private Boolean approved;
  private Boolean criticReview;

  public Review(Integer id, String movieId, Integer userId, Integer rating, String Title, String Body, Integer likes,
                Boolean approved, Boolean criticReview) {
    this.id = id;
    this.movieId = movieId;
    this.userId = userId;
    this.rating = rating;
    this.Title = Title;
    this.Body = Body;
    this.likes = likes;
    this.approved = approved;
    this.criticReview = criticReview;
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

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getBody() {
    return Body;
  }

  public void setBody(String body) {
    this.Body = Body;
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

  public String getTitle() {
    return Title;
  }

  public void setTitle(String Title) {
    this.Title = Title;
  }

  public Boolean getCriticReview() {
    return criticReview;
  }

  public void setCriticReview(Boolean criticReview) {
    this.criticReview = criticReview;
  }
}
