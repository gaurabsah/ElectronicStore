package com.store.electronic.controllers;

import com.store.electronic.dtos.AddItemToCartRequest;
import com.store.electronic.dtos.CartDto;
import com.store.electronic.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/{userId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable String userId, @Valid @RequestBody AddItemToCartRequest addItemToCartRequest) {
        CartDto cartDto = cartService.addItemToCart(userId, addItemToCartRequest);
        logger.info("Item added to cart: {}", cartDto.getCartId());
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/remove/{cartItemId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable String userId, @PathVariable int cartItemId) {
        cartService.removeItemFromCart(userId, cartItemId);
        logger.info("Item removed from cart: {}", cartItemId);
        return new ResponseEntity<>("Removed Item!!!", HttpStatus.OK);
    }

    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> removeAllItemsFromCart(@PathVariable String userId) {
        cartService.removeAllItemsFromCart(userId);
        logger.info("All Items removed from cart: {}", userId);
        return new ResponseEntity<>("Removed All Items!!!", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> fetchCartByUser(@PathVariable String userId) {
        CartDto cartDto = cartService.fetchCart(userId);
        logger.info("Cart fetched for user: {}", userId);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }
}
