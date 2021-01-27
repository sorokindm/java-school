package com.jschool.reha.dto;

import com.jschool.reha.dto.validation.PatternConstraint;
import com.jschool.reha.enums.AssignmentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int quantity;

    @PatternConstraint
    private PatternDto pattern;

    private LocalDate assignmentStartDate;

    private LocalDate assignmentEndDate;

    private String closedComments;

}
