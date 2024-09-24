package com.microtech.productcnn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // It will create Setter and Getter methods
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String name;
    private double price;
    private String description;
    private String entryDate;
}
