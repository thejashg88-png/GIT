package com.girmiti.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.ecommerce.entity.Cart;
import com.girmiti.ecommerce.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Cart cart) {
        cartRepository.save(cart);
    }

	public Object getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addToCart(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
