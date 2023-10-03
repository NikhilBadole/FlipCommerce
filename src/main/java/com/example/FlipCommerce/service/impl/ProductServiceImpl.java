package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.requestdto.ProductRequestDto;
import com.example.FlipCommerce.dto.responsedto.ProductResponseDto;
import com.example.FlipCommerce.exception.SellerNotFoundException;
import com.example.FlipCommerce.model.Product;
import com.example.FlipCommerce.model.Seller;
import com.example.FlipCommerce.repository.ProductRepository;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.service.ProductService;
import com.example.FlipCommerce.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller = sellerRepository.findByEmailId(productRequestDto.getSellerEmailId());

        if(seller == null){
            throw new SellerNotFoundException("EmailId is not registered");
        }

        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto);
        seller.getProducts().add(product);  // add product in seller product list
        product.setSeller(seller);  // add seller int product

        Seller savedSeller = sellerRepository.save(seller); // product and seller both saved with single line of code

        return ProductTransformer.productToProductResponseDto(product);
    }

    // Function to convert Product List to ProductResponseDto List
    public List<ProductResponseDto> productsToProductResponseDtos(List<Product> products){

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            productResponseDtos.add(ProductTransformer.productToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    public List<ProductResponseDto> getAllProductsByCategoryAndPrice(Category category, int price){

        List<Product> products = productRepository.findByCategoryAndPrice(category,price);

        return productsToProductResponseDtos(products);
    }

    public List<ProductResponseDto> getAllProductsByCategory(Category category){

        List<Product> products = productRepository.findByCategory(category);

        return productsToProductResponseDtos(products);
    }

    public List<ProductResponseDto> getAllProductByCategoryByPriceGreater(Category category){
        List<Product> products = productRepository.findByCategoryAndPriceGreater(category);

        return productsToProductResponseDtos(products);
    }
}
