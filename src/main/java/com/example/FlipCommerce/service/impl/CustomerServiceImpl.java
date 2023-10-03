package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.requestdto.CustomerRequestDto;
import com.example.FlipCommerce.dto.responsedto.CustomerResponseDto;
import com.example.FlipCommerce.model.Cart;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.service.CustomerService;
import com.example.FlipCommerce.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){

        // dto --> entity
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);

        // cart setting
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        // adding updated customer
        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);
    }

    // Function convert customer list to customerResponseDto List
    public List<CustomerResponseDto> customersToCustomerResponseDtos(List<Customer> customers){

        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();

        for(Customer customer : customers){
            customerResponseDtoList.add(CustomerTransformer.CustomerToCustomerResponseDto(customer));
        }

        return customerResponseDtoList;
    }

    public List<CustomerResponseDto> getFemaleFromAgeBetween20and30(){
        List<Customer> customers = customerRepository.findByAge();

        return customersToCustomerResponseDtos(customers);
    }

    public List<CustomerResponseDto> getAllMaleLessThanAge45(){
        List<Customer> customers = customerRepository.findByAgeMale();

        return customersToCustomerResponseDtos(customers);
    }

    public List<CustomerResponseDto> getAllCustomerWhoOrderAtLeast_K_Orders(int k){
        List<Customer> customers = customerRepository.findAll();

        List<Customer> customersHavingAtLeastKOrder = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getOrders().size() >= k){
                customersHavingAtLeastKOrder.add(customer);
            }
        }

        return customersToCustomerResponseDtos(customersHavingAtLeastKOrder);
    }
}
