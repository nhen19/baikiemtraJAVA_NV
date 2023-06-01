package com.bai3.bai5.validator.annotation;

import com.bai3.bai5.validator.ValidCategoryIDValidator;
import jakarta.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ValidCategoryID.List.class)
@Constraint(validatedBy = ValidCategoryIDValidator.class)
@Documented
public @interface ValidCategoryID{
    String message() default "Invalid categoryID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        ValidCategoryID[] value();
    }
}
