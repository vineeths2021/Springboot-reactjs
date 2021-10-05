package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;

/**
 * Repository for Product
 * 
 * @author home
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
