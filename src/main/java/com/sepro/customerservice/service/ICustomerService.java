package com.sepro.customerservice.service;

import com.sepro.customerservice.dto.CustomerDto;
import com.sepro.customerservice.entity.Customer;
import com.sepro.customerservice.error.UserAlreadyExistException;

import java.io.IOException;

public interface ICustomerService {

    Customer registerNewCustomerAccount(CustomerDto accountDto) throws UserAlreadyExistException, IOException;

}
