package com.ecommerce.products.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.products.entity.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long> {

}
