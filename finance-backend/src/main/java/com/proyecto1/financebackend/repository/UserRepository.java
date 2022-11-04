package com.proyecto1.financebackend.repository;

// Importing the necessary libraries to use the JPA repository.
import com.proyecto1.financebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Creating a repository for the User class.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email like ?1")
    List<User> selectByEmail(String email);
}