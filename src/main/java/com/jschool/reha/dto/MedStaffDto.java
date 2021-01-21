package com.jschool.reha.dto;

import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.entity.User;
import com.jschool.reha.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Med Staff Dto
 * @author Dmitry Sorokin
 */
@Data
public class MedStaffDto implements Serializable {

    private int idMedStaff;

    private String name;

    private String lastName;

    private Gender gender;

    private String specialty;

    private User user;

    private List<Treatment> treatmentList;

    private List<MedEvent> medEventsList;

}
