package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.dto.responsedto.CustomerResponseDto;
import com.example.FlipCommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT c FROM Customer c WHERE c.gender = 'FEMALE' and c.age BETWEEN 20 and 30", nativeQuery = false)
    List<Customer> findByAge();

    @Query(value = "SELECT c FROM Customer c WHERE c.gender = 'MALE' and c.age < 45", nativeQuery = false)
    List<Customer> findByAgeMale();

    Customer findByEmailId(String emailId);
}
