package com.attornatus.managePeople.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/***Author:Sílvia Santos Martins***/

@Constraint(validatedBy = CepValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CEP {
    String label() default "CEP";
    String message() default "Invalid zip code!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
