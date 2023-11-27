package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.service.UserServiceModel;
import com.plannerapp.myplannerproject.repository.UserRepository;
import com.plannerapp.myplannerproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceImplTestIT {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        // Clear existing users before each test
        userRepository.deleteAll();
    }

    @Test
    public void testRegisterUserAndFindByUserNameAndPassword() {
        // Create a UserServiceModel
        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setUsername("testUser");
        userServiceModel.setPassword("testPassword");
        userServiceModel.setEmail("testEmail@abv.bg");

        // Register the user
        userService.registerUser(userServiceModel);

        // Find the registered user by username and password
        UserServiceModel foundUser = userService.findByUserNameAndPassword("testUser", "testPassword");

        // Assert that the user was found
        assertNotNull(foundUser);
        assertEquals(userServiceModel.getUsername(), foundUser.getUsername());
        assertEquals(userServiceModel.getPassword(), foundUser.getPassword());
        assertEquals(userServiceModel.getEmail(), foundUser.getEmail());
    }
}