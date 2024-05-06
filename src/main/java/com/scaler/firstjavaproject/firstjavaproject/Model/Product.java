package com.scaler.firstjavaproject.firstjavaproject.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private int id;
    private String title;
    private String price;
    private String description;
    private String imageURL;
    private Category category;
}
