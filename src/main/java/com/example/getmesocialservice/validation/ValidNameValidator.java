package com.example.getmesocialservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value.matches("[a-z 1]+")){
            return true;
        }
        return false;
    }
}
