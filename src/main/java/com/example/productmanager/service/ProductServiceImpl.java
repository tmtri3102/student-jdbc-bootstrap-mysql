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
