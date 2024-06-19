package com.project.demo.logic.entity.product;

import com.project.demo.logic.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %?1%")
    List<Product> findProductsByNameContaining(String keyword);

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findProductsByCategoryId(Long categoryId);



}