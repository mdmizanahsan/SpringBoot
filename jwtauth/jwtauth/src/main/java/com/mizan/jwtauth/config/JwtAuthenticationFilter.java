package com.mizan.jwtauth.config;

import com.mizan.jwtauth.service.CustomUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // read Authorization header
        String header = request.getHeader("Authorization");
        String token = null;

        if (header != null && header.startsWith("Bearer ")) {
            // remove "Bearer " prefix
            token = header.substring(7);
        }

        // if token present and no authentication set in context
        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // token ko validate karna hai
            if (jwtUtils.validateToken(token)) {

                // extract username (email) from token
                String username = jwtUtils.getUsernameFromToken(token);

                // load user details from database
                var userDetails = userService.loadUserByUsername(username);

                // create authentication token for spring security
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // attach request details
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // set authentication in context -> user now authenticated for this request

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                // continue the filter chain
                filterChain.doFilter(request, response);

            }
        }



    }

}
