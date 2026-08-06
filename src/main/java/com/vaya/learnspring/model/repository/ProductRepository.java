package com.vaya.learnspring.model.repository;

import com.vaya.learnspring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {

}