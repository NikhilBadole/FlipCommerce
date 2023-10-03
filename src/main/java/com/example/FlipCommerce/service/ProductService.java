package com.example.FlipCommerce.service;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.requestdto.ProductRequestDto;
import com.example.FlipCommerce.dto.responsedto.ProductResponseDto;
import com.example.FlipCommerce.exception.SellerNotFoundException;

import java.util.List;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;

    public List<ProductResponseDto> getAllProductsByCategoryAndPrice(Category category, int price);

    public List<ProductResponseDto> getAllProductsByCategory(Category category);

    public List<ProductResponseDto> getAllProductByCategoryByPriceGreater(Category category);
}
