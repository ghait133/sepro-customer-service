package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.dto.UserDto;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.error.UserAlreadyExistException;

import java.io.IOException;

public interface ICustomerService {

    Customer registerNewCustomerAccount(CustomerDto accountDto) throws UserAlreadyExistException, IOException;

}
