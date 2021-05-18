package com.softuni.judgeV2.models.view;

public class HomeworkViewModel {
    private Long id;
    private String gitAddress;

    public HomeworkViewModel() {
    }

    public Long getId() {
        return id;
    }

    public HomeworkViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
