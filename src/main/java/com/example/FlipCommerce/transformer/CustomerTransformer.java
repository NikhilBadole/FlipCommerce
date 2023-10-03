package com.example.FlipCommerce.transformer;

import com.example.FlipCommerce.dto.requestdto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responsedto.CustomerResponseDto;
import com.example.FlipCommerce.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){

        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo())
                .build();
    }
}
