package com.joaodcpjunior.workshopmongo.dtos;

import java.io.Serializable;

import com.joaodcpjunior.workshopmongo.entities.User;

public class UserDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
