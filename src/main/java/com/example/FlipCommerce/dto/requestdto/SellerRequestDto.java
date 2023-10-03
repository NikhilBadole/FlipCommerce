package com.example.FlipCommerce.dto.requestdto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerRequestDto {

    String name;

    String emailId;

    String mobNo;

}
