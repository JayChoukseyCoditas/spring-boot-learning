package com.example.SpringOauth2Demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(){
        return "Welcome to Jay's World!!!";
    }

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal OAuth2User principal) {
        return "Hello, " + principal.getAttribute("name") + "! Your email is " + principal.getAttribute("email");
    }
}
