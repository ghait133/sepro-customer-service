package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.entity.CustomerPartner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<CustomerPartner,Long> {

    //List<CustomerPartner> findAllPartnerId(Long partnerId);
    List<CustomerPartner> findByCustomerId(Long customerId);


}
