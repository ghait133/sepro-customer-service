package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String email);


    @Override
    Optional<Customer> findById(Long id);
    //List<Customer> findAllByParnterId(Long partnerId);

}
