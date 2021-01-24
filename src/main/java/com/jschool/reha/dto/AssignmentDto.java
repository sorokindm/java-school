package com.jschool.reha.dto;

import com.jschool.reha.enums.AssignmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Asignment DTO
 *
 * @author Dmitry Sorokin
 */
@Getter
@Setter
@NoArgsConstructor
public class AssignmentDto implements Serializable {

    private int idAssignment;

    private TreatmentDto treatment;

    private AssignmentType type;

    private String name;

    private String dosage;

    private int quantity;

    private PatternDto pattern;

    private LocalDate assignmentStartDate;

    private LocalDate assignmentEndDate;

    private String closedComments;

}
