package com.vaya.learnspring.model.controller;

import com.vaya.learnspring.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {

        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Phone", 20000));

    }

    @GetMapping("/")
    public String greet() {
        return "Home page";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {

        return products;

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {

        products.add(product);

        return product;

    }

}