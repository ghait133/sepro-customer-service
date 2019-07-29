package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.dto.UserDto;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.error.UserAlreadyExistException;
import com.example.customerservice.repository.CostumerRepository;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    CostumerRepository costumerRepository;
    @Override
    public Customer registerNewCustomerAccount(CustomerDto accountDto) throws UserAlreadyExistException, IOException {
        if (emailExists(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final Customer customer = new Customer();
        customer.setVorname(accountDto.getVorname());
        customer.setNachname(accountDto.getNachname());
        customer.setEmail(accountDto.getEmail());
        customer.setTelNumbre(accountDto.getTelNumbre());

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{" +
                "\"email\":\"" + accountDto.getEmail() + "\","+
                "\"password\":\"" + accountDto.getPassword()+ "\","+
                "\"matchingPassword\":\"" + accountDto.getMatchingPassword() + "\","+
                "\"role\":\"role_customer\""+
                "}");
        Request request = new Request.Builder()
                .url("http://localhost:8073/registration")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        client.newCall(request).execute();
        //restTemplate.postForObject("http://user-service/registration", user,String.class);
        //OAuth2AccessToken oAuth2AccessToken = restTemplate.getAccessToken();
        return costumerRepository.save(customer);
    }
    private boolean emailExists(final String email) {
        return costumerRepository.findByEmail(email) != null;
    }



}
