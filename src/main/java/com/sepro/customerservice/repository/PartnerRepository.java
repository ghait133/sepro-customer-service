package com.sepro.customerservice.repository;

import com.sepro.customerservice.entity.CustomerPartner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<CustomerPartner,Long> {

    //List<CustomerPartner> findAllPartnerId(Long partnerId);
    List<CustomerPartner> findByCustomerId(Long customerId);


}
