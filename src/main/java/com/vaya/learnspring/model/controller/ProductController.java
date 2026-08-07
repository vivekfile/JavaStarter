package com.vaya.learnspring.model.controller;

import com.vaya.learnspring.model.Product;
import com.vaya.learnspring.model.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/products")
    public List<Product> getProducts() {

        return repository.findAll();

    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {

        return repository.findById(id).orElse(null);

    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        return repository.save(product);

    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable int id,
                          @RequestBody Product product) {

        product.setId(id);

        return repository.save(product);

    }
    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable int id) {

        repository.deleteById(id);

        return "Deleted";

    }


    }

