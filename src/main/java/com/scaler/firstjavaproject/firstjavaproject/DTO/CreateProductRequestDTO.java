package com.scaler.firstjavaproject.firstjavaproject.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
/*
    title: 'test product',
    price: 13.5,
    description: 'lorem ipsum set',
    image: 'https://i.pravatar.cc',
    category: 'electronic'
 */
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
