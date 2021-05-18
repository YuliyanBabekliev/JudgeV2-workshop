package com.softuni.judgeV2.service.impl;

import com.softuni.judgeV2.models.entities.Comment;
import com.softuni.judgeV2.models.service.CommentServiceModel;
import com.softuni.judgeV2.repository.CommentRepository;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.service.CommentService;
import com.softuni.judgeV2.service.HomeworkService;
import com.softuni.judgeV2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
    }

    @Override
    public void add(CommentServiceModel serviceModel, Long homeworkId) {
        Comment comment = modelMapper.map(serviceModel, Comment.class);
        comment.setAuthor(userService.findById(currentUser.getId()));
        comment.setHomework(homeworkService.findById(homeworkId));

        commentRepository.save(comment);
    }

    @Override
    public Double findAvgScore() {
        return commentRepository.findAvgScore();
    }

    @Override
    public Map<Integer, Integer> findScoreMap() {
        Map<Integer, Integer> scoreMap = initScoreMap();
        commentRepository
                .findAll()
                .forEach(comment -> {
                    Integer score = comment.getScore();
                    scoreMap.put(score, scoreMap.get(score) + 1);
                });
        return scoreMap;
    }

    private Map<Integer, Integer> initScoreMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= 6; i++) {
            map.put(i, 0);
        }
        return map;
    }
}
