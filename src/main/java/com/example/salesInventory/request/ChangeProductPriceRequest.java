package com.example.salesInventory.request;

import lombok.Data;

@Data
public class ChangeProductPriceRequest {
    private Long id;
    private Double price;
}
