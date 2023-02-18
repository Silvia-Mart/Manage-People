package com.attornatus.managePeople.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<CEP, String> {

    @Override
    public void initialize(CEP constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean containsLetters = value.matches(".*[a-zA-Z].*");
        if (containsLetters){
            return false;
        }
        if(value.length() != 8){
            return false;
        }
        return true;
    }
}
