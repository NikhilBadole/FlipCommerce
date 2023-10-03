package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.requestdto.SellerRequestDto;
import com.example.FlipCommerce.dto.responsedto.SellerResponseDto;

public interface SellerService {
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);
}
