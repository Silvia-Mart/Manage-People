package com.attornatus.managePeople.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<Telephone, String> {
    @Override
    public void initialize(Telephone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean containsLetters = value.matches(".*[a-zA-Z].*");
        if (containsLetters){
            return false;
        }
        if(value.length() != 11){
            return false;
        }
        return true;
    }
}
