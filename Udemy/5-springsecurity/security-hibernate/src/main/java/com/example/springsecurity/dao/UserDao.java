package com.example.springsecurity.dao;

import com.example.springsecurity.entity.User;

public interface UserDao {
    User findByUserName(String name);
}
