package com.plannerapp.myplannerproject.service;

import com.plannerapp.myplannerproject.model.entity.User;
import com.plannerapp.myplannerproject.model.service.UserServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {

    void initUsers();

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String username, String password);

}
