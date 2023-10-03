package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.requestdto.SellerRequestDto;
import com.example.FlipCommerce.dto.responsedto.SellerResponseDto;
import com.example.FlipCommerce.model.Seller;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.service.SellerService;
import com.example.FlipCommerce.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto){

        //dto --> entity
        Seller seller = SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);

        // save seller
        Seller savedSeller = sellerRepository.save(seller);

        // entity --> respDto
        return SellerTransformer.sellerToSellerResponseDto(savedSeller);
    }
}
