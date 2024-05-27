package com.code.whiskers.mic_e_commerce_auth.user.domain.entities;

import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;


    private Set<Role> roles = new HashSet<>();

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
