package com.springboot.restaurant.controllers;

import com.springboot.restaurant.models.User;
import com.springboot.restaurant.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        User newUser=userService.register(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user){
        User userFromDb=userService.logIn(user);
        return new ResponseEntity<>(userFromDb,HttpStatus.FOUND);
    }
}
