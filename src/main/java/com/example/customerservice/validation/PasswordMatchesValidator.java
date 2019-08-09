package com.example.customerservice.validation;



import com.example.customerservice.dto.CustomerDto;
import com.example.customerservice.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final CustomerDto partner = (CustomerDto) obj;
        return partner.getPassword().equals(partner.getConfirmPassword());
    }

}
