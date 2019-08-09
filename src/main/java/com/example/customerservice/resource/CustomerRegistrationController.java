package com.example.customerservice.resource;

import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.dto.UserDto;
import com.example.customerservice.entity.Customer;
import com.example.customerservice.model.CustomPrincipal;
import com.example.customerservice.service.CustomerService;
import com.example.customerservice.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


@RestController
public class CustomerRegistrationController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('role_partner')")
    public String context() {
        CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return principal.getUsername() + " " + principal.getEmail();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('role_partner','role_user')")
    public String secured(CustomPrincipal principal) {
        return principal.getUsername() + " " + principal.getEmail();
    }

    @GetMapping("/common")
    public String general() {
        return "common api success";
    }

    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GenericResponse registerUserAccount(@Valid @RequestBody final CustomerDto customerForm, final HttpServletRequest request) {
        try {
            customerService.registerNewCustomerAccount(customerForm);
        } catch (IOException e) {
            return new GenericResponse("error");
        }
        return new GenericResponse("success");
    }


}
