package com.code.whiskers.mic_e_commerce_auth.user.infrastructure.models;

import com.code.whiskers.mic_e_commerce_auth.user.domain.entities.User;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModelDTO extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public UserModelDTO(){
        super();
    }

    public UserModelDTO(Long id, String username, String password){
        super(id, username, password);
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserModelDTO(String username, String password){
        super(username, password);
        this.username = username;
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Long getId() {
        return id;
    }
}
