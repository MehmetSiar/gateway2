package com.api1.gateway2.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TokenManager {

    private static final String SECRET_KEY = "yourSecretKey"; // Güvenli bir şekilde saklanmalıdır
    private static final long EXPIRATION_TIME = 864_000_000; // 10 gün (milisaniye cinsinden)
    public String getDatalogging(String token , String userName) {
        return userName + "~" + token + "~" + System.currentTimeMillis();
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }
}
