package com.wam.springbootshop.service;

import java.util.Optional;

import com.wam.springbootshop.model.User;

/**
 * @author Wyllian
 */

public interface UserServiceable {
    public User saveUser(User user);
    Optional<User> findByUsername(String username);
    void changeRoleToAdmin(String username);
}
