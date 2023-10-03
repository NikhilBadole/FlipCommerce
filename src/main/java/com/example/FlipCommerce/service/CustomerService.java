package com.example.FlipCommerce.service;


import com.example.FlipCommerce.dto.requestdto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responsedto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    public List<CustomerResponseDto> getFemaleFromAgeBetween20and30();

    public List<CustomerResponseDto> getAllMaleLessThanAge45();

    public List<CustomerResponseDto> getAllCustomerWhoOrderAtLeast_K_Orders(int k);

    interface CardService {
    }
}
