package com.example.controller;

import com.example.controller.dto.ProductListDto;
import com.example.controller.form.AddProductForm;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products/list")
    public String list(Model model) {
        model.addAttribute("products", ProductListDto.from(productService.getKeys()));
        return "list";
    }

    @GetMapping("/products/add")
    public String add(Model model) {
        model.addAttribute("form", new AddProductForm());
        return "add";
    }

    @PostMapping("/products/add")
    public String addOk(@ModelAttribute("form") AddProductForm form) {
        productService.addProduct(form);
        return "redirect:/products/list";
    }
}
