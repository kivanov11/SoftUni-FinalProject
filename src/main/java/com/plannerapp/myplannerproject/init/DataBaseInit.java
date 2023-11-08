package com.plannerapp.myplannerproject.init;

import com.plannerapp.myplannerproject.service.UserRoleService;
import com.plannerapp.myplannerproject.service.UserService;
import com.plannerapp.myplannerproject.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {



    private final UserService userService;
    private final CategoryService categoryService;
    private final UserRoleService userRoleService;

    public DataBaseInit(UserService userService, CategoryService categoryService, UserRoleService userRoleService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.userRoleService = userRoleService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.initUsers();
        categoryService.initCategories();
        userRoleService.initRoles();
    }


}
