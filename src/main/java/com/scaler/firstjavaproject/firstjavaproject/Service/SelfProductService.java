package com.scaler.firstjavaproject.firstjavaproject.Service;

import com.scaler.firstjavaproject.firstjavaproject.Exception.CategoryNotFoundException;
import com.scaler.firstjavaproject.firstjavaproject.Model.Category;
import com.scaler.firstjavaproject.firstjavaproject.Model.Product;
import com.scaler.firstjavaproject.firstjavaproject.Repository.CategoryRepository;
import com.scaler.firstjavaproject.firstjavaproject.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, double price, String image, String category) throws CategoryNotFoundException {
        Product p = new Product();
        Category c = categoryRepository.findByName(category);
        if(c == null){
            throw new CategoryNotFoundException("category not found in DB");
        }
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(String.valueOf(price));
        p.setImageURL(image);
        p.setCategory(c);
        Product UpdatedProduct = productRepository.save(p);
        return UpdatedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
