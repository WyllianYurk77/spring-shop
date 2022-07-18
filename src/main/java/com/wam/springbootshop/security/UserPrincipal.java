package com.wam.springbootshop.security;

import java.util.Collection;
import java.util.Set;

import com.wam.springbootshop.model.Role;
import com.wam.springbootshop.model.User;
import com.wam.springbootshop.util.SecurityUtils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Wyllian
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;
    private transient String password; // transient makes it doesn't show up on serialized places
    private transient User user; // only for login operation, not used in JWT
    private Set<GrantedAuthority> authorities;

    public static UserPrincipal createSuperUser() {
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));

        return UserPrincipal.builder()
                .id(-1L)
                .username("system-admin")
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
