package com.example.finalJava.Service;

import com.example.finalJava.dto.Cart;

public interface ICartService {

    Cart getCartById(Long id);

    Cart addToCart(Long cartId, Integer productId, Integer quantity);

    Cart delete(Cart cart);

//    Orders checkout(Long cartId);
}
