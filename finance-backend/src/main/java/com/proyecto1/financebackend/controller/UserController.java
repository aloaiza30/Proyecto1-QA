package com.proyecto1.financebackend.controller;

import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.User;
import com.proyecto1.financebackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user){
        User responseUser = userService.saveUser(user);
        if (responseUser == null) {
            return new ResponseEntity<>("Error while saving User", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }
    @GetMapping("/getCategories")
    public Optional<List<Category>> getCategories(@RequestParam Integer id){
        return userService.getCategories(id);
    }
}
