package com.softuni.judgeV2.service.impl;

import com.softuni.judgeV2.models.entities.RoleName;
import com.softuni.judgeV2.models.entities.User;
import com.softuni.judgeV2.models.service.UserServiceModel;
import com.softuni.judgeV2.models.view.UserProfileViewModel;
import com.softuni.judgeV2.repository.UserRepository;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.service.RoleService;
import com.softuni.judgeV2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setRole(roleService.findRole(RoleName.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleName roleName) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user.getRole().getName() != roleName) {
            user.setRole(roleService.findRole(roleName));

            userRepository.save(user);
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserProfileViewModel findProfileById(Long id) {
        User user = userRepository.findById(id).orElse(null);

       UserProfileViewModel userProfileViewModel =  modelMapper
                .map(user, UserProfileViewModel.class);

       userProfileViewModel.setHomeworkSet(user.getHomeworkSet().stream().map(homework -> homework.getExercise().getName())
       .collect(Collectors.toSet()));

       return userProfileViewModel;
    }
}
