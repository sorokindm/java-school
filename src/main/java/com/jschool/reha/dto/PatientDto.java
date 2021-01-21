package com.jschool.reha.dto;

import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.entity.User;
import com.jschool.reha.enums.Gender;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Patient Dto
 * @author Dmitry Sorokin
 */
@Data
public class PatientDto implements Serializable {

    private int idPatient;

    private String name;

    private String lastName;

    private Gender gender;

    private String idInsurance;

    private User user;

    private List<Treatment> treatmentList;

    private List<MedEvent> medEventsList;

}
