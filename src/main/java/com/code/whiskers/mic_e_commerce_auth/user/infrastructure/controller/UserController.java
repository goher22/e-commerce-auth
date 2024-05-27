package com.code.whiskers.mic_e_commerce_auth.user.infrastructure.controller;

import com.code.whiskers.mic_e_commerce_auth.user.application.port.in.UserPortIn;
import com.code.whiskers.mic_e_commerce_auth.user.application.services.UserService;
import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;
import com.code.whiskers.mic_e_commerce_auth.user.domain.response.LoginResponse;
import com.code.whiskers.mic_e_commerce_auth.user.domain.services.UserServiceCU;
import com.code.whiskers.mic_e_commerce_auth.user.infrastructure.service.UserMysqlAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController implements UserServiceCU {

    private final UserPortIn userPortIn;

    public UserController(UserMysqlAdapter userMysqlAdapter, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userPortIn = new UserService(userMysqlAdapter, bCryptPasswordEncoder);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody User user) {
        try{
            LoginResponse loginResponse = this.userPortIn.auth(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(loginResponse);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try{
            return ResponseEntity.ok(this.userPortIn.registerUser(user.getUsername(), user.getPassword()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
