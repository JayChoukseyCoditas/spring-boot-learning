package com.example.springsecurity.dao;

import com.example.springsecurity.entity.Role;

public interface RoleDao {
    Role findRoleByName(String role);
}
