package com.jschool.reha.dto.validation;

import com.jschool.reha.dao.interfaces.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext ctx) {
        return !userDAO.isUserExist(s);
    }
}
