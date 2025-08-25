package com.example.bean_configuration.service;

import com.example.bean_configuration.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private int maxUsersAllowed;
    UserRepository userRepository;

    public UserService(){

    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserInfo(){
        return "User information from UserService";
    }

    public void setMaxUsersAllowed(int maxUsersAllowed) {
        this.maxUsersAllowed = maxUsersAllowed;
    }

    public static UserService createServiceWithCustomConfig() {
        return new UserService();
    }

}
