package com.justclick.authservice.services;

import java.util.List;

import com.justclick.authservice.domains.Role;
import com.justclick.authservice.domains.User;

public interface UserService {
    User writeUser(User user);
    
    Role writeRole(Role role);
    
    void addRoleToUser(String username, String rolename);
    
    User getUserByUsername(String username);
    
    List<User> getAllUser();
}
