package com.scaler.firstjavaproject.firstjavaproject.Service;

import com.scaler.firstjavaproject.firstjavaproject.Exception.CategoryNotFoundException;
import com.scaler.firstjavaproject.firstjavaproject.Model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(int id);

    Product createProduct(String title, String description, double price, String image, String category) throws CategoryNotFoundException;

    List<Product> getAllProducts();
}
