package com.api1.gateway2.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Provider;
import java.util.Date;
@Service
public class TokenGenerator {
    private static final String SECRET_KEY = "123123341231232142143413231231432513412312321321312"; // Güvenli bir şekilde saklanmalıdır
    private static final long EXPIRATION_TIME = 864_000_000; // 10 gün (milisaniye cinsinden)


    @Autowired
    private File file;

    public String generateToken(String username) {
        String token = "";
        try {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();

            file.writeToFile( getDatalogging(token, username) ,"./src/main/resources/AuthLogging");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return token;
    }
    private  String getDatalogging(String token , String userName) {
        return userName + "~" + token + "~" + System.currentTimeMillis();
    }

}
