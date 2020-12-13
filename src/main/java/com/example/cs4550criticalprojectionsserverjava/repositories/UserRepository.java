package com.example.cs4550criticalprojectionsserverjava.repositories;

import com.example.cs4550criticalprojectionsserverjava.models.Comment;

import com.example.cs4550criticalprojectionsserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer>{

    @Query(value = "SELECT username FROM users WHERE username=:username", nativeQuery = true)
    public List<String> findMatchingUsernames(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE username=:username", nativeQuery = true)
    public List<User> findUserByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE username=:username AND password=:password", nativeQuery = true)
    public List<User> findUserByLogin(@Param("username") String username,
                                      @Param("password") String password);

}
