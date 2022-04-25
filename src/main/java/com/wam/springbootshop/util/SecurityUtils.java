package com.wam.springbootshop.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Wyllian
 */

public class SecurityUtils {
    
    public static final String ROLE_PREFIX = "ROLE_";

    private SecurityUtils() {
        
    }

    public static SimpleGrantedAuthority convertToAuthority(String role) {
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formattedRole);
    }
}
