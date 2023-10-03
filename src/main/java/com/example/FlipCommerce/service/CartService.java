package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.requestdto.CheckoutCartRequestDto;
import com.example.FlipCommerce.dto.requestdto.ItemRequestDto;
import com.example.FlipCommerce.dto.responsedto.CartResponseDto;
import com.example.FlipCommerce.dto.responsedto.OrderResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.EmptyCartException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.InvalidCardException;
import com.example.FlipCommerce.model.Item;

public interface CartService {
    public CartResponseDto addToCart(Item item, ItemRequestDto itemRequestDto);

    public OrderResponseDto checkOutCart(CheckoutCartRequestDto checkoutCartRequestDto) throws CustomerNotFoundException, InvalidCardException, EmptyCartException, InsufficientQuantityException;
}
