package com.code.whiskers.mic_e_commerce_auth.user.domain.response;

public class LoginResponse {
    private String token;

    public LoginResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
