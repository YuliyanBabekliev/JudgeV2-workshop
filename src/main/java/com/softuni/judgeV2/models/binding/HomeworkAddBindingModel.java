package com.softuni.judgeV2.models.binding;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class HomeworkAddBindingModel {
    private String exercise;
    private String gitAddress;

    public HomeworkAddBindingModel() {
    }


    @Size(min = 2)
    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+", message = "Enter valid git address.")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}
