package com.example.customerservice.resource;

import com.example.customerservice.dto.CustomerList;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //SYSTEM-Endpoint
    @RequestMapping(value = "/getcustomersbyidlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public CustomerList changeUserPassword(@RequestBody List<Long> customerIds) {

        return customerService.getCustomersByIds(customerIds);
    }

    //USER-Endpoint
    @RequestMapping(value = "/getcustomerbyid/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public Optional<Customer> getcustomerInfobyId(@PathVariable Long customerId){
    //TODO show if Partner(Principal user) has an relationship to the customer in Customer_partner Table
        return customerService.getCustomerById(customerId);
    }

}
