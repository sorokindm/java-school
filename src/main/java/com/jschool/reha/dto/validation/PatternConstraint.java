package com.jschool.reha.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternConstraint {
    String message() default "Pattern should not be empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
