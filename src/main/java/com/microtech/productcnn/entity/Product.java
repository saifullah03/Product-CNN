package com.microtech.productcnn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Create table in database
@Data // Al fields setter and getter methods
@NoArgsConstructor // Create no argument constructor
@AllArgsConstructor // Create all arguments constructor
public class Product {
    @Id // unique cloumn - unique value
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Create a unique value
    private Long id;
    private String name;
    private double price;
    private String description;
    private String entryDate;

}
