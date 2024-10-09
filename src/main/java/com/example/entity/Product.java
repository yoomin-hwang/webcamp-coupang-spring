package com.example.entity;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
