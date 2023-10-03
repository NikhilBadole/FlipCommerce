package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.requestdto.ItemRequestDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.OutOfStockException;
import com.example.FlipCommerce.exception.ProductNotFoundException;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.model.Item;
import com.example.FlipCommerce.model.Product;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.service.CustomerService;
import com.example.FlipCommerce.service.ItemService;
import com.example.FlipCommerce.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public Item createItem(ItemRequestDto itemRequestDto) throws CustomerNotFoundException, ProductNotFoundException, OutOfStockException, InsufficientQuantityException {

        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmailId());
        if(customer == null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        Optional<Product> productOptional = productRepository.findById(itemRequestDto.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product doesn't exist");
        }
        Product product = productOptional.get();

        if(product.getQuantity()==0){
            throw new OutOfStockException("Product is out of stock");
        }
        if(product.getQuantity()<itemRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Sorry! The required quantity is not available");
        }

        Item item = ItemTransformer.itemRequestDtoToItem(itemRequestDto.getRequiredQuantity());
        return item;   // this item only contains req_qauntity because there is problem of duplicacy in database thas why we will set customer and product in cartService
    }
}
