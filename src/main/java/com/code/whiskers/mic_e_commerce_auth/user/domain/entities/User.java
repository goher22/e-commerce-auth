package com.code.whiskers.mic_e_commerce_auth.user.domain.entities;

import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String password;
    private Long roleId;
    private boolean enabled;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.roleId = 1L;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = 1L;
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

    public Long getRoleId() {
        return roleId;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
