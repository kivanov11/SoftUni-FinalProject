package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.Category;
import com.plannerapp.myplannerproject.model.enums.CategoryName;
import com.plannerapp.myplannerproject.repository.CategoryRepository;
import com.plannerapp.myplannerproject.service.CategoryService;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {


        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        switch (categoryName) {
                            case WEEKLY_PLANNER -> category.setDescription("A weekly planner is a schedule of your plans and activities over a week. It enables you to manage your time, track tasks, and organize your team by day.");
                            case WEDDING_PLANNER -> category.setDescription("Wedding planners support couples and their families with the organisation, hiring, purchasing and management involved with planning a successful wedding. For some clients, they will only be involved in specific aspects of the process, such as hiring caterers and entertainment or supporting on the day itself.");
                            case DIGITAL_PLANNER -> category.setDescription("A digital planner is simply a digital version of the paper planner, and is often an interactive PDF that you can download. They can mimic the experience of using a traditional planner, as you will be able to scribble in them like you would with a traditional paper planner.");

                        }
                        categoryRepository.save(category);
                    });
        }

    @Override
    public Category findByCategoryEnum(CategoryName categoryName) {


        return categoryRepository.findByName(categoryName).orElse(null);
    }

}

