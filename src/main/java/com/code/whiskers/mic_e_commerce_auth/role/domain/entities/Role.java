package com.code.whiskers.mic_e_commerce_auth.role.domain.entities;

import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Long id;
    private String name;
    private Set<User> users = new HashSet<>();

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
