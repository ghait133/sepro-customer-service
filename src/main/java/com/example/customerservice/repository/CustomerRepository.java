package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CostumerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String email);
    //List<Customer> findAllByParnterId(Long partnerId);

}
