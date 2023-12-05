package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.Order;
import com.plannerapp.myplannerproject.model.entity.User;
import com.plannerapp.myplannerproject.model.enums.CategoryName;
import com.plannerapp.myplannerproject.model.service.OrderServiceModel;
import com.plannerapp.myplannerproject.repository.OrderRepository;
import com.plannerapp.myplannerproject.service.CategoryService;
import com.plannerapp.myplannerproject.service.UserService;
import com.plannerapp.myplannerproject.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceImplTestIT {

    @Mock
    private OrderRepository orderRepositoryMock;

    @Mock
    private ModelMapper modelMapperMock;

    @Mock
    private UserService userServiceMock;

    @Mock
    private CategoryService categoryServiceMock;

    @Mock
    private HttpSession httpSessionMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testAddOrder() {
        // Mock data
        OrderServiceModel orderServiceModel = new OrderServiceModel();
        orderServiceModel.setCategory(CategoryName.MY_PLANNER); // Set category

        Order mappedOrder = new Order();
        mappedOrder.setCategory(null); // To be filled by categoryService.findByCategoryEnum()

        when(modelMapperMock.map(orderServiceModel, Order.class)).thenReturn(mappedOrder);

        // Call the method to be tested
        orderService.addOrder(orderServiceModel);

        // Verify interactions
        verify(modelMapperMock).map(orderServiceModel, Order.class);
        verify(categoryServiceMock).findByCategoryEnum(CategoryName.MY_PLANNER);
        verify(orderRepositoryMock).save(any(Order.class));
    }
}

