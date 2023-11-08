package com.plannerapp.myplannerproject.repository;

import com.plannerapp.myplannerproject.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


}
