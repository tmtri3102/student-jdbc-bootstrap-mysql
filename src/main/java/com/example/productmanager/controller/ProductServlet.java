package com.example.productmanager.controller;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.ProductService;
import com.example.productmanager.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();

//    ===============================   GET   =============================== //

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
            // -> back to localhost?
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "update":
                showUpdatePage(request, response);
                break;
            case "delete":
                showDeletePage(request, response);
                break;
            case "read":
                readDetail(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) {}
    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) {}
    private void showDeletePage(HttpServletRequest request, HttpServletResponse response) {}
    private void readDetail(HttpServletRequest request, HttpServletResponse response) {}
    private void listProducts(HttpServletRequest request, HttpServletResponse response) {}
//    ===============================   POST   =============================== //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:

        }
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) {}
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {}
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {}
}
