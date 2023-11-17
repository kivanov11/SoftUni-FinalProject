package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.Order;
import com.plannerapp.myplannerproject.model.entity.User;
import com.plannerapp.myplannerproject.model.service.OrderServiceModel;
import com.plannerapp.myplannerproject.repository.OrderRepository;
import com.plannerapp.myplannerproject.service.CategoryService;
import com.plannerapp.myplannerproject.service.OrderService;
import com.plannerapp.myplannerproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, HttpSession httpSession) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel,Order.class);
        order.setCategory(categoryService.findByCategoryEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);



    }
}
