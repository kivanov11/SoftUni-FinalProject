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
                            case EVERY_MOMENT -> category.setDescription("A weekly planner is a schedule of your plans and activities over a week. It enables you to manage your time, track tasks, and organize your team by day.");
                            case MY_PLANNER -> category.setDescription("Stay organised and look stylish at the same time with this pretty day to day planner. It contains a daily schedule, a to do list section and your top three goals for the day . Our Daily Planner is dateless, it is always ready to use!");
                            case DREAM_IT -> category.setDescription("Remember, dreams don’t become reality without a plan… Shop your Dream Planner now! A custom planner designed by me, for daily journaling, monthly inspiration and yearly goals!");
                            case DAILY -> category.setDescription("A daily planner is a schedule of your plans and activities over a day. It enables you to manage your time, track tasks, and organize your team by day.");
                            case STAY_FEARLEESS -> category.setDescription("Start planning your year in any month with this undated planner. There's plenty of room to write important dates, to do's, goals, and your schedule. Grab yours and plan ahead!");
                            case GOOD_VIBES -> category.setDescription("A good planner is simply a digital version of the paper planner, and is often an interactive PDF that you can download. They can mimic the experience of using a traditional planner, as you will be able to scribble in them like you would with a traditional paper planner.");
                            case RECIPES_BOOK -> category.setDescription("This beautiful blank recipe book includes 100 pages for you to jot down all of your favorite recipes. The interior contains sections for the recipe name, ingredients, directions, cooking time and preparation time. This book helps you stay organized by helping you keep track of all your favorite recipes. Use this book, instead of clipping from magazines or writing recipes on sticky notes or online pin board sites. Keep track of all your *BEST* recipes easily in this one book.");
                            case READING_DIARY -> category.setDescription("The most basic form of reading diary is merely a record of what we read. It is a very simple table with columns: “date”, “book”, “pages read”,”comments”. We write down when we read, what books and articles we read, which pages we actually read that day, and what we learned from the reading.");
                            case MY_WEDDING_PLANNER -> category.setDescription("Wedding planners support couples and their families with the organisation, hiring, purchasing and management involved with planning a successful wedding. For some clients, they will only be involved in specific aspects of the process, such as hiring caterers and entertainment or supporting on the day itself.");
                        }
                        categoryRepository.save(category);
                    });
        }

    @Override
    public Category findByCategoryEnum(CategoryName categoryName) {


        return categoryRepository.findByName(categoryName).orElse(null);
    }

}

