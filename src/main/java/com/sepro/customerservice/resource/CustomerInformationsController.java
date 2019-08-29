package com.sepro.customerservice.resource;

import com.sepro.customerservice.dto.CustomerGlobalInformation;
import com.sepro.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerInformationsController {
    @Autowired
    CustomerService customerService;

    //USER-Endpoint
    @RequestMapping(value = "/getcustomerinfosbyid/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('role_partner','role_customer')")
    public CustomerGlobalInformation getcustomerInfobyId(@PathVariable Long customerId){
        //TODO show if Partner(Principal user) has an relationship to the customer in Customer_partner Table
        return customerService.getCustomerGlobalInfosById(customerId);
    }
}
