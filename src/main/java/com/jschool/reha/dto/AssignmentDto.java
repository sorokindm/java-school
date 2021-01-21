package com.jschool.reha.dto;

import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Treatment;
import com.jschool.reha.enums.AssignmentType;
import com.jschool.reha.enums.Timeframe;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Asignment DTO
 *
 * @author Dmitry Sorokin
 */
@Data
public class AssignmentDto implements Serializable {

    private int idAssignment;

    private Treatment treatment;

    private AssignmentType type;

    private String name;

    private String dosage;

    private int patternQuantity;

    private int patternHowlong;

    private Timeframe timeframe;

    private LocalDate assignmentStartDate;

    private LocalDate assignmentEndDate;

    private String endedComments;

    private List<MedEvent> medEvents;

}
