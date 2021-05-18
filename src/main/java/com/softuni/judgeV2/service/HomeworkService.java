package com.softuni.judgeV2.service;

import com.softuni.judgeV2.models.entities.Homework;
import com.softuni.judgeV2.models.service.HomeworkServiceModel;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();

    Homework findById(Long homeworkId);
}
