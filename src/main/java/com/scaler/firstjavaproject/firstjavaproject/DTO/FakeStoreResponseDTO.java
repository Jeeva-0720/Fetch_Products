package com.scaler.firstjavaproject.firstjavaproject.DTO;

import com.scaler.firstjavaproject.firstjavaproject.Model.Category;
import com.scaler.firstjavaproject.firstjavaproject.Model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private int id;
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;

    public Product convertToProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setDescription(description);
        p.setImageURL(image);
        p.setPrice(price);
        Category c = new Category();
        c.setName(category);
        c.setId(id);
        p.setCategory(c);

        return p;

    }

}
