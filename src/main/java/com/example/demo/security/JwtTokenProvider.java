package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private String jwtSecret = "default-secret-key-for-tests";
    private long validityInMilliseconds = 3600000; // 1 hour
    private final Key key;

    // ✅ REQUIRED by Spring + Tests
    public JwtTokenProvider() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // ✅ REQUIRED by Integration Tests
    public JwtTokenProvider(String secret, long validityInMs) {
        this.jwtSecret = secret;
        this.validityInMilliseconds = validityInMs;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // ✅ TEST EXPECTS THIS NAME
    public String createToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ TEST EXPECTS THIS NAME
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
