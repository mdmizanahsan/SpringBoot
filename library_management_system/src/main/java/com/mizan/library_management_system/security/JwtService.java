package com.mizan.library_management_system.security;

import com.mizan.library_management_system.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final Key key;              // Injected from JwtConfig
    private final long expirationMs;    // Injected from JwtConfig

    // ✅ Generate JWT Token for a user
    public String generateToken(User user) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(user.getUsername())             // username inside token
                .claim("role", user.getRole().name())       // add role claim
                .setIssuedAt(now)                           // token issue time
                .setExpiration(exp)                         // token expiry
                .signWith(key, SignatureAlgorithm.HS256)    // signing key + algorithm
                .compact();                                 // build the token
    }

    // ✅ Validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            return false; // invalid or expired token
        }
    }

    // ✅ Extract username from token
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // ✅ Extract role from token (optional helper)
    public String extractUserRole(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }
}
