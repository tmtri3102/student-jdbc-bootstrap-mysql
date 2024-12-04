package com.example.productmanager.service;

import com.example.productmanager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Macbook", "Nice laptop", 52.25));
        products.put(2, new Product(2, "Yoga laptop", "Nice laptop", 34.50));
        products.put(3, new Product(3, "LG Laptop", "Nice laptop", 45.65));
        products.put(4, new Product(4, "Asus Vivobook", "Nice laptop", 56.75));
    }

    @Override
    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void createProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product searchById(int id) {
        return products.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }
}
