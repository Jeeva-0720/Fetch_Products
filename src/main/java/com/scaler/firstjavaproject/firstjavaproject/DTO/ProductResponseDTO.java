package com.scaler.firstjavaproject.firstjavaproject.DTO;

import com.scaler.firstjavaproject.firstjavaproject.Model.Category;
import lombok.Data;

@Data

public class ProductResponseDTO {
    private int id;
    private String title;
    private String price;
    private String description;
    private String imageURL;
    private Category category;
}
