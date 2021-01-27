package com.jschool.reha.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatientValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatientConstraint {
    String message() default "Such Insurance Id exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
