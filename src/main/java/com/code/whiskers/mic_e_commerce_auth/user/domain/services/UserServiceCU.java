package com.code.whiskers.mic_e_commerce_auth.user.domain.services;


import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;
import com.code.whiskers.mic_e_commerce_auth.user.domain.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface UserServiceCU {
    public ResponseEntity<LoginResponse> authenticateUser(String username, String password);
    public ResponseEntity<String> registerUser(User user);
}
