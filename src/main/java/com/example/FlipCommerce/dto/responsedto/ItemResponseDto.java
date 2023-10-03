package com.example.FlipCommerce.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResponseDto {

    int quantityAdded;

    String productName;

    int price;
}
