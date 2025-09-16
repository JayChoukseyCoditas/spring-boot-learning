package com.example.test.services;

import com.example.test.dtos.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> registerUser(UserDto userDto);
}
