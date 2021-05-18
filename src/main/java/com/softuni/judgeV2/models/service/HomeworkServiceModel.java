package com.softuni.judgeV2.models.service;

import com.softuni.judgeV2.models.entities.Exercise;
import com.softuni.judgeV2.models.entities.User;

import java.time.LocalDateTime;

public class HomeworkServiceModel {
    private Long id;
    private LocalDateTime addedOn;
    private String gitAddress;
    private UserServiceModel author;

    public HomeworkServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public UserServiceModel getAuthor() {
        return author;
    }

    public void setAuthor(UserServiceModel author) {
        this.author = author;
    }
}
