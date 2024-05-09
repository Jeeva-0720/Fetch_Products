package com.scaler.firstjavaproject.firstjavaproject.Model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseModel {
    @Id
    private Integer id;
    private Date created_date;
    private boolean deleted;

}
