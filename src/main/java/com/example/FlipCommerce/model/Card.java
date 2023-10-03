package com.example.FlipCommerce.model;

import com.example.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "card_no", unique = true, nullable = false)
    String cardNo;

    @Column(name = "cvv")
    int cvv;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    CardType cardType;

    @Column(name = "valid_till")
    Date validTill;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
