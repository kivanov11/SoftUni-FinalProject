package com.plannerapp.myplannerproject.service;

import com.plannerapp.myplannerproject.model.entity.Category;
import com.plannerapp.myplannerproject.model.enums.CategoryName;
import org.springframework.stereotype.Service;


public interface CategoryService {

    void initCategories();

    Category findByCategoryEnum(CategoryName categoryName);
}
