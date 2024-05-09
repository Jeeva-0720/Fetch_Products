package com.scaler.firstjavaproject.firstjavaproject.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title;
    private String price;
    private String description;
    private String imageURL;
@ManyToOne(cascade = {CascadeType.REMOVE})
    private Category category;
}
