package com.plannerapp.myplannerproject.web;

import com.plannerapp.myplannerproject.web.ContactsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testContactsPage() throws Exception {
        // Perform GET request to /contacts endpoint and expect HTTP 200 status
        mockMvc.perform(get("/contacts"))
                .andExpect(status().isOk())
                .andExpect(view().name("contacts")); // Expecting "contacts" view name
    }
}