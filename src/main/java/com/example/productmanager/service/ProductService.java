package com.example.productmanager.service;

import com.example.productmanager.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    void createProduct(Product product);
    Product searchById(int id);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
}
