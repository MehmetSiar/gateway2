package com.api1.gateway2.model;

public class Auth {
    private  String token;
    private final String userName;
    private final int expirationTime = 3600;

    public Auth(String token, String userName) {
        this.token = token;
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpirationTime() {
        return expirationTime;
    }

}
