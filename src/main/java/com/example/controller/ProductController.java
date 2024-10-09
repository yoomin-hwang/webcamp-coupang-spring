package com.example.controller;

import com.example.dto.ProductListDto;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/products/list")
    public String list(Model model) {
        model.addAttribute("products", ProductListDto.from(productService.getKeys()));
        return "list";
    }
}
