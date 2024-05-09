package com.scaler.firstjavaproject.firstjavaproject.Repository;

import com.scaler.firstjavaproject.firstjavaproject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);

    List<Product> getAllProducts();

//    Product getProductById(Integer id);
}
