package com.proyecto1.financebackend.controller;

import com.google.gson.Gson;
import com.proyecto1.financebackend.DTO.LoginDTO;
import com.proyecto1.financebackend.model.Category;
import com.proyecto1.financebackend.model.User;
import com.proyecto1.financebackend.service.user.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private static final Gson gson = new Gson();
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
        return userService.getUserCategories(id);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        JSONObject response = new JSONObject();

        Optional<User> user = userService.getUserByEmail(loginDTO.getEmail());
        if (user.isPresent()) {
            if (Objects.equals(user.get().getPassword(), loginDTO.getPassword())) {
                return ResponseEntity.ok(gson.toJson(user.get()));
            } else {
                response.put("message", "Wrong Credentials");
                return new ResponseEntity<>(response.toJSONString(), HttpStatus.UNAUTHORIZED);
            }
        } else {
            response.put("message", "User Not Found");
            return new ResponseEntity<>(response.toJSONString(), HttpStatus.NOT_FOUND);
        }
    }
}
