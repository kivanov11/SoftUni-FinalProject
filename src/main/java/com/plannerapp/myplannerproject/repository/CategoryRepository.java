package com.plannerapp.myplannerproject.repository;

import com.plannerapp.myplannerproject.model.entity.Category;
import com.plannerapp.myplannerproject.model.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    Optional<Category> findByName(CategoryName name);
}
