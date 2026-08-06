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
        products.add(new Product(2, "keyboard", 30000));
        products.add(new Product(2, "mouse", 50000));

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

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id,
                                 @RequestBody Product updatedProduct) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getId() == id) {

                products.set(i, updatedProduct);

                return updatedProduct;
            }
        }

        return null;

    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id) {

        for (Product product : products) {

            if (product.getId() == id) {

                products.remove(product);

                return "Product Deleted";
            }
        }

        return "Product Not Found";
    }

}