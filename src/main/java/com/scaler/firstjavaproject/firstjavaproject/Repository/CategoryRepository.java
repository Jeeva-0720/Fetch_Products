package com.scaler.firstjavaproject.firstjavaproject.Repository;

import com.scaler.firstjavaproject.firstjavaproject.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

}
