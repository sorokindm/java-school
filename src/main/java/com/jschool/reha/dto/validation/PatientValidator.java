package com.jschool.reha.dto.validation;

import com.jschool.reha.dao.interfaces.PatientDAO;
import com.jschool.reha.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatientValidator implements ConstraintValidator<PatientConstraint, PatientDto> {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public boolean isValid(PatientDto dto, ConstraintValidatorContext ctx) {
        if (dto==null) return true;
        return !patientDAO.isPatientExistWithInsuranceId(dto.getIdInsurance());
    }
}
