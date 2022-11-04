package com.proyecto1.financebackend.service.user;

// This is importing the necessary libraries.
import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.model.User;
import com.proyecto1.financebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * It's a service class that implements the UserService interface
 */
@Service
public class UserServiceImpl implements UserService {
    // It's injecting the UserRepository dependency.
    @Autowired
    private UserRepository userRepository;

    /**
     * The function takes in a user object, saves it to the database, and returns the saved user object
     * 
     * @param user The user object that we want to save.
     * @return The user object is being returned.
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Get the user with the given id, get the categories of that user, and return the categories
     * 
     * @param id The id of the user
     * @return Optional<List<Category>>
     */
    @Override
    public Optional<List<Category>> getUserCategories(Integer id) {
        Optional<User> user = userRepository.findAllById(Collections.singleton(id)).stream().findFirst();
        user.get().getCategories();
        return user.map(User::getCategories);
    }

    /**
     * Get the user's savings if the user exists.
     * 
     * @param id The id of the user whose savings we want to retrieve.
     * @return Optional<Savings>
     */
    @Override
    public Optional<Savings> getUserSavings(Integer id) {
        Optional<User> user = userRepository.findAllById(Collections.singleton(id)).stream().findFirst();
        return user.map(User::getSavings);
    }

    /**
     * Get the first user from the database that has the given email.
     * 
     * @param email The email of the user to be retrieved.
     * @return Optional<User>
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.selectByEmail(email).stream().findFirst();
    }

    /**
     * This function returns an Optional of type User, which is the result of calling the findById
     * function on the userRepository object, passing in the id parameter
     * 
     * @param id The id of the user to be retrieved.
     * @return Optional<User>
     */
    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * It deletes a user by id.
     * 
     * @param id The id of the user to be deleted.
     */
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}
