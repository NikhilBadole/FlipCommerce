package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.requestdto.ItemRequestDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.OutOfStockException;
import com.example.FlipCommerce.exception.ProductNotFoundException;
import com.example.FlipCommerce.model.Item;

public interface ItemService {

    public Item createItem(ItemRequestDto itemRequestDto) throws CustomerNotFoundException, ProductNotFoundException, OutOfStockException, InsufficientQuantityException;
}
