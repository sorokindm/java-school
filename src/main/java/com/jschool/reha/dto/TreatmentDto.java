package com.jschool.reha.dto;

import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.entity.Patient;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Treatment Dto
 * @author Dmitry Sorokin
 */

@Data
public class TreatmentDto implements Serializable {

    private int idTreatment;

    private MedStaff doctor;

    private Patient patient;

    private LocalDate treatmentOpened;

    private String diagnosis;

    private String openedComments;

    private LocalDate treatmentClosed;

    private String closedComments;

    private List<Assignment> assignments;

}
