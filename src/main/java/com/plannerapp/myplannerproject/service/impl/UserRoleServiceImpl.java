package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.UserRoleEntity;
import com.plannerapp.myplannerproject.model.enums.UserRoleEnum;
import com.plannerapp.myplannerproject.repository.UserRoleRepository;
import com.plannerapp.myplannerproject.service.UserRoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void initRoles() {

//        if(userRoleRepository.count() == 0){
//            var userRole = new UserRoleEntity().setRole(UserRoleEnum.USER);
//            var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
//
//            userRoleRepository.save(userRole);
//            userRoleRepository.save(adminRole);
//        }
    }
}
