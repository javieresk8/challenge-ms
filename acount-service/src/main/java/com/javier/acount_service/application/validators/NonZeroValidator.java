package com.javier.acount_service.application.validators;

import com.javier.acount_service.application.annotations.NonZero;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonZeroValidator implements ConstraintValidator<NonZero, Double> {
    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        return aDouble != null && aDouble != 0;
    }
}
