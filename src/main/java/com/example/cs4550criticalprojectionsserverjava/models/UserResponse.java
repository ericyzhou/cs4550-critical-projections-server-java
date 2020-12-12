package com.example.cs4550criticalprojectionsserverjava.models;

public class UserResponse {
    private Integer response;
    private User user;

    public UserResponse(Integer response) {
        this.response = response;
    }

    public UserResponse(Integer response, User user) {
        this.response = response;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }
}
