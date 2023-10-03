package com.example.FlipCommerce.dto.requestdto;

import com.example.FlipCommerce.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequestDto {

    String name;

    String emailId;

    String mobNo;

    int age;

    Gender gender;
}
