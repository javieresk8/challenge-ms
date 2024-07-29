package com.javier.acount_service.application.annotations;

import com.javier.acount_service.application.validators.NonZeroValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NonZeroValidator.class)
public @interface NonZero {
    String message() default "The value must be greater than zero";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
