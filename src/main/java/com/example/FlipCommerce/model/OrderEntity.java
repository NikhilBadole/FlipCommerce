package com.example.FlipCommerce.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="order_info")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "order_no")
    String orderNo;

    @Column(name = "total_value")
    int totalValue;

    @Column(name = "order_date")
    @CreationTimestamp
    Date orderDate;

    @Column(name = "card_used")
    String cardUsed;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Customer customer;
}
