package com.softuni.judgeV2.service;

import com.softuni.judgeV2.models.service.CommentServiceModel;

import java.util.Map;

public interface CommentService {
    void add(CommentServiceModel serviceModel, Long homeworkId);

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
