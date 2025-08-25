package com.example.bean_configuration.rest;

import com.example.bean_configuration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final UserService userService;

    @Autowired
    public OrderController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/order")
    public String placeOrder(){
        return userService.getUserInfo();
    }
}
