// This is the controller for the user. It is the one that will receive the requests from the frontend
// and will call the service to do the operations.
package com.proyecto1.financebackend.controller;

// This is importing all the classes that are needed for the controller to work.
import com.google.gson.Gson;
import com.proyecto1.financebackend.DTO.LoginDTO;
import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.Savings;
import com.proyecto1.financebackend.model.User;
import com.proyecto1.financebackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// This is a Spring annotation that is used to mark a class as a controller.
@RestController
@RequestMapping("/user")
@CrossOrigin
/**
 * It's a controller class that handles all the requests that are related to the user
 */
public class UserController {
    // Injecting the UserService class into the controller.
    @Autowired
    private UserService userService;

    // A static variable that is used to convert the objects into JSON.
    private static final Gson gson = new Gson();

    /**
     * If the user doesn't exist, save the user and return the user. If the user does exist, return an
     * error message
     * 
     * @param user The user object that is sent in the request body.
     * @return ResponseEntity<String>
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        if(userService.getUserByEmail(user.getEmail()).isEmpty()) {
            User responseUser = userService.saveUser(user);
            if (responseUser == null) {
                return new ResponseEntity<>("Error while saving User", HttpStatus.CONFLICT);
            }
            return ResponseEntity.ok(gson.toJson(user));
        } else {
            return new ResponseEntity<>(String.format("User with the email %s already exists", user.getEmail()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This function returns a list of categories that a user has created
     * 
     * @param id The id of the user whose categories you want to get.
     * @return A list of categories that the user has.
     */
    @GetMapping("/getCategories")
    public Optional<List<Category>> getCategories(@RequestParam Integer id){
        return userService.getUserCategories(id);
    }

    /**
     * This function returns the savings of a user with the given id
     * 
     * @param id The id of the user whose savings you want to get.
     * @return A savings object
     */
    @GetMapping("/getSavings")
    public Optional<Savings> getSavings(@RequestParam Integer id){
        return userService.getUserSavings(id);
    }

    /**
     * If the user exists, and the password is correct, return the user. Otherwise, return an error
     * 
     * @param loginDTO This is the object that will be sent to the server.
     * @return A ResponseEntity object is being returned.
     */
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {

        Optional<User> user = userService.getUserByEmail(loginDTO.getEmail());
        if (user.isPresent()) {
            if (Objects.equals(user.get().getPassword(), loginDTO.getPassword())) {
                return ResponseEntity.ok(gson.toJson(user.get()));
            } else {
                return new ResponseEntity<>( "Wrong Credentials", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * If the user exists, delete the user and return a success message. If the user doesn't exist,
     * return a not found message
     * 
     * @param id The id of the user to be deleted.
     * @return A ResponseEntity object is being returned.
     */
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Integer id) {
        if (userService.getUserById(id).isPresent()) {
            try {
                userService.deleteUser(id);
            } catch (Exception e) {
                return new ResponseEntity<>("Error while deleting user", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
