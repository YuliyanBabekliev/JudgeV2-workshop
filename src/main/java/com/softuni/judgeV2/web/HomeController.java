package com.softuni.judgeV2.web;


import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.service.CommentService;
import com.softuni.judgeV2.service.ExerciseService;
import com.softuni.judgeV2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final CommentService commentService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, CommentService commentService, UserService userService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.isAnonymous()){
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllExNames());

        model.addAttribute("avg", commentService.findAvgScore());
        model.addAttribute("usersCount", userService.findAllUsernames().size());
        model.addAttribute("scoreMap", commentService.findScoreMap());
        return "home";
    }
}
