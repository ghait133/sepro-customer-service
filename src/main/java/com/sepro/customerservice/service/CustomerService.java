package com.sepro.customerservice.service;

import com.sepro.customerservice.dto.CustomerDto;
import com.sepro.customerservice.dto.CustomerGlobalInformation;
import com.sepro.customerservice.dto.CustomerList;
import com.sepro.customerservice.dto.PartnerList;
import com.sepro.customerservice.entity.Customer;
import com.sepro.customerservice.error.UserAlreadyExistException;
import com.sepro.customerservice.repository.AdresseRepository;
import com.sepro.customerservice.repository.CustomerRepository;
import com.sepro.customerservice.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.soap.SAAJResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository costumerRepository;

    @Autowired
    OAuth2RestTemplate restTemplate;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AdresseRepository adresseRepository;

    @Override
    public Customer registerNewCustomerAccount(CustomerDto customerForm) throws UserAlreadyExistException, IOException {
        if (emailExists(customerForm.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + customerForm.getEmail());
        }
        final Customer customer = new Customer();
        customer.setEmail(customerForm.getEmail());

        /*OkHttpClient client = new OkHttpClient();

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

        client.newCall(request).execute();*/
        //restTemplate.postForObject("http://user-service/registration", user,String.class);
        //OAuth2AccessToken oAuth2AccessToken = restTemplate.getAccessToken();
        return costumerRepository.save(customer);
    }
    private boolean emailExists(final String email) {
        return costumerRepository.findByEmail(email) != null;
    }

    public CustomerList getCustomersByIds(List<Long> customerIds){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAllById(customerIds).forEach(customer -> {
            customers.add(customer);
        });

        CustomerList customerList = new CustomerList(customers);

        return customerList;
    }

    public PartnerList getAllPartnersforCustomer(Long customerId){

        List<Long> partnerIds = new ArrayList<>();
        partnerRepository.findByCustomerId(customerId).forEach(customerPartner -> {
            partnerIds.add(customerPartner.getPartnerId());
        });
        PartnerList partners = restTemplate.postForObject("http://partner-service/getpartnersbyidlist",partnerIds,PartnerList.class);

        return partners;
    }

    public Optional<Customer> getCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }

    public CustomerGlobalInformation getCustomerGlobalInfosById(Long cutomerId){
        //Todo get partner (principal user) sector
        String partnerSector="Friseur";

        String url = "http://" + partnerSector.toLowerCase() +"-information-service/globalinfos/" + cutomerId;
        return restTemplate.getForObject(url,CustomerGlobalInformation.class);

    }

    public Customer getCustomerByEmail(String customerEmail){
        if (!emailExists(customerEmail)) {
            throw new UserAlreadyExistException("There is no account with that email adress: " + customerEmail);
        }
        return customerRepository.findByEmail(customerEmail);
    }

    public void updateCustomer (Customer customer){

        Customer oldCustomer = customerRepository.findById(customer.getId()).get();
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setLastName(customer.getLastName());
        oldCustomer.setAdresse(customer.getAdresse());
        adresseRepository.save(oldCustomer.getAdresse());
        oldCustomer.setBirthdate(customer.getBirthdate());
        oldCustomer.setGender(customer.getGender());
        oldCustomer.setTelNumbre(customer.getTelNumbre());
        if (!oldCustomer.getEmail().equals(customer.getEmail())){
            if (emailExists(customer.getEmail())) {
                throw new UserAlreadyExistException("There is an account with that email adress: " + customer.getEmail());
            }
            oldCustomer.setEmail(customer.getEmail());
        }
        customerRepository.save(oldCustomer);
    }

}
