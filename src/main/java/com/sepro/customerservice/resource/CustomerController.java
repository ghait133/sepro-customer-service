package com.sepro.customerservice.resource;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sepro.customerservice.dto.CustomerList;
import com.sepro.customerservice.entity.Customer;
import com.sepro.customerservice.service.CustomerService;
import com.sepro.customerservice.util.GenericResponse;
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
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public String test() {

        return "hallo from Friseur service";
    }
    //SYSTEM-Endpoint
    @RequestMapping(value = "/getcustomersbyidlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
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

    //USER-Endpoint
    @RequestMapping(value = "/getcustomerbyemail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public Customer getcustomerInfobyId(@RequestParam String customerEmail){
        //TODO show if Partner(Principal user) has an relationship to the customer in Customer_partner Table
        return customerService.getCustomerByEmail(customerEmail);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public GenericResponse updateCustomer(@RequestBody Customer customer) {

        customerService.updateCustomer(customer);
        return new GenericResponse("success");
    }
}
