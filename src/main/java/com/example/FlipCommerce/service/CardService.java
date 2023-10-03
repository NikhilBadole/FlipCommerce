package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.requestdto.CardRequestDto;
import com.example.FlipCommerce.dto.responsedto.CardResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;

public interface CardService {
   public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;
}
