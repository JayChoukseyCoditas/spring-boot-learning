package com.example.bean_configuration.service;

import org.springframework.beans.factory.annotation.Autowired;

public class UserManagementService {
    private final UserService userService;

    @Autowired
    public UserManagementService(UserService userService){
        this.userService = userService;
    }
}
