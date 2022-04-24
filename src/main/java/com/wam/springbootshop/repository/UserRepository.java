package com.wam.springbootshop.repository;

/**
 * @author Wyllian
 */

import java.util.Optional;

import com.wam.springbootshop.model.Role;

import com.wam.springbootshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("UPDATE User SET role = :role WHERE username = :username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}
