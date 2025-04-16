package org.microservices.consumer_service.anotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.microservices.consumer_service.anotations.validators.MinAgeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinAgeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})  // Define the constraint on fields and parameters (ex: function functionName(@annotation int e))
@Retention(RetentionPolicy.RUNTIME) // This annotation defines when the MinAge annotation can be accessed.
public @interface MinAge {
    String message() default "Age must be at least {value}";
    int value();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
