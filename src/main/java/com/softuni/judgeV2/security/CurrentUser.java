package com.softuni.judgeV2.security;

import com.softuni.judgeV2.models.entities.RoleName;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;
    private RoleName role;

    public CurrentUser() {
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAnonymous(){
        return this.username == null;
    }

    public boolean isAdmin(){
        return this.role == RoleName.ADMIN;
    }
}
