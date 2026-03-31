package com.girmiti.ecommerce.controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.girmiti.ecommerce.entity.Order;
import com.girmiti.ecommerce.repository.OrderRepository;
import com.girmiti.ecommerce.service.OrderService;



@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @GetMapping("/place")
    public String placeOrder() {
        orderService.placeOrder();
        return "redirect:/orders";
    }
}