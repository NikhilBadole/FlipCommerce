package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByCardNo(String cardNo);
}
