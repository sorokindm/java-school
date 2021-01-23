package com.jschool.reha.dto;

import com.jschool.reha.entity.Treatment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Treatment Dto
 *
 * @author Dmitry Sorokin
 */

@Data
@NoArgsConstructor
public class TreatmentDto implements Serializable {

    private int idTreatment;

    private MedStaffDto doctor;

    private PatientDto patient;

    private LocalDate treatmentOpened;

    private String diagnosis;

    private String openedComments;

    private LocalDate treatmentClosed;

    private String closedComments;

}
