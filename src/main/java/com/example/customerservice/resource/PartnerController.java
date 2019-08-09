package com.example.customerservice.resource;

import com.example.customerservice.dto.PartnerList;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartnerController {


    @Autowired
    CustomerService customerService;

    //USER-Endpoint
    @RequestMapping(value = "/allpartners/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PartnerList registerUserAccount(@PathVariable final Long customerId) {

        return customerService.getAllPartnersforCustomer(customerId);
    }
}
