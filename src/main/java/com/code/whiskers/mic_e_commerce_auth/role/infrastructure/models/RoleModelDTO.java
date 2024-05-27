package com.code.whiskers.mic_e_commerce_auth.role.infrastructure.models;

import com.code.whiskers.mic_e_commerce_auth.role.domain.entities.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleModelDTO extends Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public RoleModelDTO(){
        super();
    }

    public RoleModelDTO(String name) {
        super(name);
        this.name = name;
    }

    public RoleModelDTO(Long id, String name) {
        super(id, name);
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
