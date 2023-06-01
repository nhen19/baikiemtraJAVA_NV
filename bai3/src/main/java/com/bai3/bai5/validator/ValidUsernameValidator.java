package com.bai3.bai5.validator;

import com.bai3.bai5.repository.IUserRepository;
import com.bai3.bai5.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    IUserRepository userRepository;
    @Override
    public void initialize(ValidUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(userRepository==null) return true;
        return userRepository.findByUsername(username)==null;
    }
}
