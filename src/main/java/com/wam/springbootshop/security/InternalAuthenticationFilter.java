package com.wam.springbootshop.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wam.springbootshop.util.SecurityUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Wyllian
 */

@Slf4j
public class InternalAuthenticationFilter extends OncePerRequestFilter {

    private final String accessKey;

    public InternalAuthenticationFilter(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);

            if(requestKey == null || requestKey.equals(accessKey)) {
                log.warn("Internal key endpoint requested without or with wrong key uri: {}", request.getRequestURI());
                throw new RuntimeException("UNAUTHORIZED");
            }

            UserPrincipal user = UserPrincipal.createSuperUser();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            log.error("Could not set user authentication in security context", e);
        }

        filterChain.doFilter(request, response);
    }
}
