package com.example.FlipCommerce.dto.responsedto;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    String productName;

    String sellerName;

    Category category;

    int price;

    ProductStatus productStatus;
}
