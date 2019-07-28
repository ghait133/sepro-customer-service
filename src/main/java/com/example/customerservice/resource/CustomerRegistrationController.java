package com.example.customerservice.resource;

import com.example.customerservice.model.CustomPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class CustomerRegistrationController {

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('role_partner')")
    public String context() {
        CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return principal.getUsername() + " " + principal.getEmail();
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('role_admin','role_user')")
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
}
