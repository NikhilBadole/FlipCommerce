package com.example.FlipCommerce.controller;

import com.example.FlipCommerce.dto.requestdto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responsedto.CustomerResponseDto;
import com.example.FlipCommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponseDto, HttpStatus.CREATED);
    }

    // get all female customers between age 20-30
    @GetMapping("/getFemaleBetween20and30")
    public ResponseEntity getFemaleFromAgeBetween20and30(){

        List<CustomerResponseDto> customerResponseDtoList = customerService.getFemaleFromAgeBetween20and30();
        return new ResponseEntity(customerResponseDtoList, HttpStatus.FOUND);
    }

    // get all male customers less than 45
    @GetMapping("/getAllMaleLessThanAge45")
    public ResponseEntity getAllMaleLessThanAge45(){

        List<CustomerResponseDto> customerResponseDtoList = customerService.getAllMaleLessThanAge45();
        return new ResponseEntity(customerResponseDtoList, HttpStatus.FOUND);
    }

    // customers who have ordered atleast 'k' orders
    @GetMapping("/atLeast_K_Order")
    public ResponseEntity getAllCustomerWhoOrderAtLeast_K_Orders(@RequestParam int k){

        List<CustomerResponseDto> customerResponseDtoList = customerService.getAllCustomerWhoOrderAtLeast_K_Orders(k);
        return new ResponseEntity(customerResponseDtoList, HttpStatus.FOUND);
    }
}
