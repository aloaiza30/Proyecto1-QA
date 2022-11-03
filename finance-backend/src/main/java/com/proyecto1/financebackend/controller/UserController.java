package com.proyecto1.financebackend.controller;

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
import java.util.StringJoiner;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    private static final Gson gson = new Gson();

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
    @GetMapping("/getCategories")
    public Optional<List<Category>> getCategories(@RequestParam Integer id){
        return userService.getUserCategories(id);
    }

    @GetMapping("/getSavings")
    public Optional<Savings> getSavings(@RequestParam Integer id){
        return userService.getUserSavings(id);
    }

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
