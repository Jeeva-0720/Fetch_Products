package com.scaler.firstjavaproject.firstjavaproject.Controller;

import com.scaler.firstjavaproject.firstjavaproject.DTO.CreateProductRequestDTO;
import com.scaler.firstjavaproject.firstjavaproject.DTO.ProductResponseDTO;
import com.scaler.firstjavaproject.firstjavaproject.Exception.CategoryNotFoundException;
import com.scaler.firstjavaproject.firstjavaproject.Model.Product;
import com.scaler.firstjavaproject.firstjavaproject.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        ProductResponseDTO dto = convertProductTodto(product);
        return dto;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> dto = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product p: products){
            dto.add(convertProductTodto(p));
        }
        return dto;
    }

    private ProductResponseDTO convertProductTodto(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategory(product.getCategory());
        dto.setImageURL(product.getImageURL());
        return dto;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO dto) throws CategoryNotFoundException {
        Product p = productService.createProduct(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getImage(), dto.getCategory());

        return p;
    }

}
