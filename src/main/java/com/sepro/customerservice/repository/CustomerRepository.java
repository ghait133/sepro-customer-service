package com.sepro.customerservice.repository;

import com.sepro.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String email);


    @Override
    Optional<Customer> findById(Long id);
    //List<Customer> findAllByParnterId(Long partnerId);

}
