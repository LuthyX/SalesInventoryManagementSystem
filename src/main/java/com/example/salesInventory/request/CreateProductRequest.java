package com.example.salesInventory.request;

import lombok.Data;
@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
