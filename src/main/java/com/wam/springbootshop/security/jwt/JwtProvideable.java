package com.wam.springbootshop.security.jwt;

import javax.servlet.http.HttpServletRequest;

import com.wam.springbootshop.security.UserPrincipal;

import org.springframework.security.core.Authentication;

/**
 * @author Wyllian
 */

public interface JwtProvideable {
    String generateToken(UserPrincipal auth);
    Authentication getAuthentication(HttpServletRequest request);
    boolean validateToken(HttpServletRequest request);
}
