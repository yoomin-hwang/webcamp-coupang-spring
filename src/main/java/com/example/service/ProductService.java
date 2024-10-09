package com.example.service;

import com.example.controller.form.AddProductForm;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(AddProductForm form) {
        productRepository.add(Product.builder()
                .name(form.getName())
                .description(form.getDescription())
                .price(form.getPrice())
                .stock(form.getStock())
                .build());
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id);
    }
}
