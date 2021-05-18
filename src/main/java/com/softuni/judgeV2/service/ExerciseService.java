package com.softuni.judgeV2.service;

import com.softuni.judgeV2.models.entities.Exercise;
import com.softuni.judgeV2.models.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addEx(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames();

    boolean checkIfLate(String exercise);

    Exercise findByName(String name);
}
