package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.requestdto.CardRequestDto;
import com.example.FlipCommerce.dto.responsedto.CardResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.model.Card;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.service.CardService;
import com.example.FlipCommerce.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer = customerRepository.findByEmailId(cardRequestDto.getEmailId());
        if(customer == null){
            throw new CustomerNotFoundException("Invalid email id!!!");
        }

        Card card = CardTransformer.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        // save customer and card
        Customer savedCustomer = customerRepository.save(customer);

        // prepare response Dto
        return CardTransformer.CardToCardResponseDto(card);
    }
}
