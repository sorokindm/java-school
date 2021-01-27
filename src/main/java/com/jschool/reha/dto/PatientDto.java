package com.jschool.reha.dto;

import com.jschool.reha.entity.Patient;
import com.jschool.reha.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Patient Dto
 * @author Dmitry Sorokin
 */
@Data
@NoArgsConstructor
public class PatientDto implements Serializable {

    private int idPatient;

    private String name;

    private String lastName;

    private Gender gender;

    private String idInsurance;

}
