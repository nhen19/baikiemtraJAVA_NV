package com.bai3.bai5.validator;


import com.bai3.bai5.entity.PHONGBAN;
import com.bai3.bai5.validator.annotation.ValidCategoryID;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Autowired;
//
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class ValidCategoryIDValidator implements ConstraintValidator<ValidCategoryID, PHONGBAN> {

    @Override
    public void initialize(ValidCategoryID constraintAnnotation) {
    }

    @Override
    public boolean isValid(PHONGBAN category, ConstraintValidatorContext context) {
        return  category!=null && category.getMa_Phong()!=null&& !category.getMa_Phong().isBlank();
    }
}
