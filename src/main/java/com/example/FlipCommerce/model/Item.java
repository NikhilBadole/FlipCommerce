package com.example.FlipCommerce.model;

import lombok.Data;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "required_quantity")
    int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn
    Cart cart;
}
