package com.jschool.reha.dto;

import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Med Staff Dto
 * @author Dmitry Sorokin
 */
@Data
@NoArgsConstructor
public class MedStaffDto implements Serializable {

    private int idMedStaff;

    private String name;

    private String lastName;

    private Gender gender;

    private String specialty;

    public MedStaffDto(MedStaff medStaff)
    {
        idMedStaff=medStaff.getIdMedStaff();
        name=medStaff.getName();
        lastName=medStaff.getLastName();
        gender=medStaff.getGender();
        specialty=medStaff.getSpecialty();
    }
}
