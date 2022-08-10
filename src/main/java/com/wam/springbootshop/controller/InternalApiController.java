package com.wam.springbootshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wam.springbootshop.service.UserServiceable;

/**
 * @author Wyllian
 */

@RestController
@RequestMapping("api/internal")
public class InternalApiController {

    @Autowired
    private UserServiceable userService;

    @PutMapping("make-admin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable String username) {

        userService.changeRoleToAdmin(username);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
