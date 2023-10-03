package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.requestdto.OrderRequestDto;
import com.example.FlipCommerce.dto.responsedto.OrderResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.InvalidCardException;
import com.example.FlipCommerce.exception.ProductNotFoundException;
import com.example.FlipCommerce.model.Card;
import com.example.FlipCommerce.model.Cart;
import com.example.FlipCommerce.model.OrderEntity;

public interface OrderService {
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantityException, InvalidCardException;
    public OrderEntity placeOrder(Cart cart, Card card) throws InsufficientQuantityException;
}
