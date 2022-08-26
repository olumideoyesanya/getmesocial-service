package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {
    @Id
    private String id;
    private String name;

    @Email
    private String email;

    @NotEmpty
    private String ProfilePhotoUrl;

    public User() {
    }

    public User(String name, String email, String profilePhotoUrl) {
        this.name = name;
        this.email = email;
        this.ProfilePhotoUrl = profilePhotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhotoUrl() {
        return ProfilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.ProfilePhotoUrl = profilePhotoUrl;
    }
}

