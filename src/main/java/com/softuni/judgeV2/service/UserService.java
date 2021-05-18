package com.softuni.judgeV2.service;

import com.softuni.judgeV2.models.entities.RoleName;
import com.softuni.judgeV2.models.entities.User;
import com.softuni.judgeV2.models.service.UserServiceModel;
import com.softuni.judgeV2.models.view.UserProfileViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleName valueOf);

    User findById(Long id);

    UserProfileViewModel findProfileById(Long id);
}
