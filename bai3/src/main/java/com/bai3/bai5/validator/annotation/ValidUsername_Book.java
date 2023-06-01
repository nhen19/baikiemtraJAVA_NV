package com.bai3.bai5.validator.annotation;

import com.bai3.bai5.validator.ValidUsernameValidator;
import com.bai3.bai5.validator.ValidUsername_Book_Validator;
import jakarta.validation.Constraint;

import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUsername_Book_Validator.class)
@Documented
public @interface ValidUsername_Book {
    String message() default "Invalid username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
