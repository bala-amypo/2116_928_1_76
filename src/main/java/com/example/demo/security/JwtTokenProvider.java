package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 86400000; // 1 day

    /* =========================
       MAIN TOKEN METHODS
       ========================= */

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public String generateToken(UserPrincipal principal) {
        return generateToken(principal.getUsername());
    }

    public String getUsernameFromToken(String token) {
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
        } catch (JwtException ex) {
            return false;
        }
    }

    /* =========================
       🔥 COMPATIBILITY METHODS
       (REQUIRED BY TESTS & OLD CODE)
       ========================= */

    // Used by AuthController
    public String createToken(String username) {
        return generateToken(username);
    }

    // Used by JwtAuthenticationFilter
    public String getUsername(String token) {
        return getUsernameFromToken(token);
    }
}
