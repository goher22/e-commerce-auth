package com.code.whiskers.mic_e_commerce_auth.user.application.services;

import com.code.whiskers.mic_e_commerce_auth.user.application.port.in.UserPortIn;
import com.code.whiskers.mic_e_commerce_auth.user.application.port.out.UserPortOut;
import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;
import com.code.whiskers.mic_e_commerce_auth.user.domain.response.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

public class UserService implements UserPortIn {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserPortOut userPortOut;
    private final String secretKey = "bZbBY87UVfaF";

    public UserService(UserPortOut userPortOut) {
        this.userPortOut = userPortOut;
    }

    @Override
    public LoginResponse auth(String username, String password) {
        try {

            User user = this.userPortOut.findByUsername(username);
            if(user != null){
                if(this.passwordEncoder.matches(password, user.getPassword())){

                    int minuto = 30;
                    long tiempoExpiracion = (long) minuto * 60L * 1000L;
                    Date fechaActual = new Date();
                    Date fechaExpiracion = new Date(fechaActual.getTime() + tiempoExpiracion);

                    String jwt = Jwts.builder()
                            .setSubject(user.getId().toString())
                            .setIssuedAt(fechaActual)
                            .setExpiration(fechaExpiracion)
                            .signWith(SignatureAlgorithm.HS256, secretKey)
                            .compact();
                    return new LoginResponse(jwt);
                }

            }
            throw new IllegalArgumentException("Authentication failed");
        }catch (Exception e) {
            throw new IllegalArgumentException("Authentication failed");
        }
    }

    @Override
    public String registerUser(String username, String password) {
        try{
            User user = this.userPortOut.findByUsername(username);
            if(user == null){
                User newuser = new User(username, passwordEncoder.encode(password));
                this.userPortOut.saveUser(newuser);
                return "User Saved Successfully";
            }else{
                throw new IllegalArgumentException("The username already exists");
            }

        }catch (Exception e){
            throw new IllegalArgumentException("Error saving user");
        }
    }


}
