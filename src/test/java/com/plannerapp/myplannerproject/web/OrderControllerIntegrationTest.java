package com.plannerapp.myplannerproject.web;

import com.plannerapp.myplannerproject.model.binding.OrderAddBindingModel;
import com.plannerapp.myplannerproject.service.OrderService;
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
@Transactional // Rollback transactions after each test
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService; // Mock or use test doubles if needed

    @Test
    public void testOrderPage() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(view().name("order-add"));
    }
}


//    @Test
//    public void testOrderConfirmValidData() throws Exception {
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("name=John", "price=40"); // Add valid fields
//
//        mockMvc.perform(post("/order").params(params))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/#")); // Assuming successful redirection to the home page
//    }
//
//    @Test
//    public void testOrderConfirmInvalidData() throws Exception {
//        // Simulating invalid data by not adding required fields
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//
//        mockMvc.perform(post("/order").params(params))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/order")); // Expecting redirection back to /order due to validation errors
//    }
//}
