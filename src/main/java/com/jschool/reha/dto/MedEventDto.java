package com.jschool.reha.dto;

import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.enums.MedEventStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * MedEvent Dto
 * @author Dmitry Sorokin
 */
@Data
public class MedEventDto implements Serializable {

    private int idMedEvent;

    private Assignment assignment;

    private MedStaff nurse;

    private LocalDateTime starts;

    private MedEventStatus status;

    private Patient patient;

}
