package com.api1.gateway2.controller;

import com.api1.gateway2.model.Auth;
import com.api1.gateway2.service.File;
import com.api1.gateway2.service.TokenGenerator;
import com.api1.gateway2.util.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthController {
    @Autowired
    private TokenGenerator tokenGenerator;

    @PostMapping("/login")
    public Auth login(@RequestParam("username") String username) {
        String token = tokenGenerator.generateToken(username);
        Auth auth = new Auth(token,username);
        return auth;
    }
}
