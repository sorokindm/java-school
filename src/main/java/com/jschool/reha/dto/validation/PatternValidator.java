package com.jschool.reha.dto.validation;

import com.jschool.reha.dao.interfaces.PatientDAO;
import com.jschool.reha.dto.PatternDto;
import com.jschool.reha.dto.helpers.PatternEntityDtoHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<PatternConstraint, PatternDto> {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public boolean isValid(PatternDto dto, ConstraintValidatorContext ctx) {
        if (dto == null) return false;
        if (!PatternEntityDtoHelper.isValid(dto)) return false;
        return true;
    }
}
