package com.example.FlipCommerce.transformer;

import com.example.FlipCommerce.dto.requestdto.SellerRequestDto;
import com.example.FlipCommerce.dto.responsedto.SellerResponseDto;
import com.example.FlipCommerce.model.Seller;

public class SellerTransformer {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .mobNo(sellerRequestDto.getMobNo())
                .emailId(sellerRequestDto.getEmailId())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){

        return SellerResponseDto.builder()
                .name(seller.getName())
                .mobNo(seller.getMobNo())
                .build();
    }
}
