package com.plannerapp.myplannerproject.service.impl;

import com.plannerapp.myplannerproject.model.entity.Category;
import com.plannerapp.myplannerproject.model.enums.CategoryName;
import com.plannerapp.myplannerproject.repository.CategoryRepository;
import com.plannerapp.myplannerproject.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoryServiceImplTestIT {

    @Mock
    private CategoryRepository categoryRepositoryMock;

    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepositoryMock);
    }

    @Test
    public void testInitCategories() {
        // Mock categoryRepository.count() to return 0
        when(categoryRepositoryMock.count()).thenReturn(0L);

        // Mock categoryRepository.save() method
        doAnswer(invocation -> {
            Category category = invocation.getArgument(0);
            // Simulate saving by setting an ID (assuming Category has setId method)
            category.setId(1L);
            return category;
        }).when(categoryRepositoryMock).save(any(Category.class));

        // Call the method to be tested
        categoryService.initCategories();

        // Verify that save method is called for each CategoryName enum
        verify(categoryRepositoryMock, times(CategoryName.values().length)).save(any(Category.class));
    }

    @Test
    public void testFindByCategoryEnum() {
        // Mock categoryRepository.findByName() for a specific CategoryName
        Category expectedCategory = new Category();
        expectedCategory.setId(1L);
        expectedCategory.setName(CategoryName.EVERY_MOMENT);
        expectedCategory.setDescription("A weekly planner...");

        when(categoryRepositoryMock.findByName(CategoryName.EVERY_MOMENT)).thenReturn(Optional.of(expectedCategory));

        // Call the method to be tested
        Category foundCategory = categoryService.findByCategoryEnum(CategoryName.EVERY_MOMENT);

        // Verify that the correct category is returned
        assertEquals(expectedCategory.getName(), foundCategory.getName());
        assertEquals(expectedCategory.getDescription(), foundCategory.getDescription());
    }
}