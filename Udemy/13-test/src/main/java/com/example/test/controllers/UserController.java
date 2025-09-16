package com.example.test.controllers;

import com.example.test.dtos.UserDto;
import com.example.test.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }
}
