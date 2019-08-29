package com.sepro.customerservice.validation;



import com.sepro.customerservice.dto.CustomerDto;

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
