package com.plannerapp.myplannerproject.web;

import com.plannerapp.myplannerproject.model.binding.UserLoginBindingModel;
import com.plannerapp.myplannerproject.model.binding.UserRegisterBindingModel;
import com.plannerapp.myplannerproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService; // Mock or use test doubles if needed

    @Test
    public void testRegisterPage() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }


    @Test
    public void testLoginValidData() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "testUser");
        params.add("password", "testPassword");

        mockMvc.perform(post("/login").params(params))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/")); // Assuming successful redirection to the home page
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(get("/logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/")); // Assuming successful redirection to the home page after logout
    }
}
