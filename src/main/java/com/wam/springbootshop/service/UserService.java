package com.wam.springbootshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.wam.springbootshop.model.Role;
import com.wam.springbootshop.model.User;
import com.wam.springbootshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Wyllian
 */

@Service
public class UserService implements UserServiceable {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional // Transactional is required when executing an update/delete query
    public void changeRoleToAdmin(String username) {
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}
