package com.girmiti.ecommerce.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.girmiti.ecommerce.entity.Product;
import com.girmiti.ecommerce.service.ProductService;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Show product form
    @GetMapping("/add-product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // Save product
    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    // Show all products
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
        
        
    }
}
