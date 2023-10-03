package com.example.FlipCommerce.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {

    int cartTotal;

    String customerName;

    List<ItemResponseDto> items;
}
