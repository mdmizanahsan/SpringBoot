package com.mizan.library_management_system.config;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
public class JwtConfig {

    private static final String SECRET_KEY = "MySuperSecretKeyForJwtTokenMySuperSecretKey"; // 32+ chars required

    @Bean
    public Key jwtSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    @Bean
    public long jwtExpirationMs() {
        return 3600000L; // 1 hour = 3600000 ms
    }
}
