package org.microservices.consumer_service.anotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.microservices.consumer_service.anotations.MinAge;

import java.time.LocalDate;
import java.time.Period;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {

    private int minAge;

    @Override
    public void initialize(MinAge constraintAnnotation) {
        this.minAge = constraintAnnotation.value();
        if (this.minAge < 0) {
            throw new IllegalArgumentException("MinAge must be a non-negative integer");
        }
    }

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        if(dob == null)
            return true;

        LocalDate today = LocalDate.now();

        if (dob.isAfter(today))
            return true;

        int age = Period.between(dob, today).getYears();

        return age < minAge;
    }
}
