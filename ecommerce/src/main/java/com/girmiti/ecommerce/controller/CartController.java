package com.girmiti.ecommerce.controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.girmiti.ecommerce.entity.Cart;
import com.girmiti.ecommerce.service.CartService;



@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

   
    
    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCart());
        return "cart";
    }

}

