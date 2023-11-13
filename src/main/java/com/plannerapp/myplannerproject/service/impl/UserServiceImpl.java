package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.User;
import com.plannerapp.myplannerproject.model.service.UserServiceModel;
import com.plannerapp.myplannerproject.repository.UserRepository;
import com.plannerapp.myplannerproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initUsers() {

    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel , User.class));
    }

    @Override
    public UserServiceModel findByUserNameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).map(user -> modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }
}
