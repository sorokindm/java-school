package com.jschool.reha.dto;

import com.jschool.reha.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Patient Dto
 *
 * @author Dmitry Sorokin
 */
@Data
@NoArgsConstructor
public class PatientDto implements Serializable {

    private int idPatient;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull(message = "Provide a gender")
    private Gender gender;

    private String idInsurance;

}
