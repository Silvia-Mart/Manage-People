package com.attornatus.managePeople.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

/***Author:Sílvia Santos Martins***/

@Constraint(validatedBy = TelephoneValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Telephone {
    String label() default "Telephone";
    String message() default "Invalid Telephone!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
