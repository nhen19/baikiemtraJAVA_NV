package com.bai3.bai5.validator;


import com.bai3.bai5.entity.User;
import com.bai3.bai5.validator.annotation.ValidCategoryID;
import com.bai3.bai5.validator.annotation.ValidUsername_Book;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidUsername_Book_Validator implements ConstraintValidator<ValidUsername_Book, User> {

    @Override
    public void initialize(ValidUsername_Book constraintAnnotation) {
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return  user!=null && user.getId()!=null;
    }
}
