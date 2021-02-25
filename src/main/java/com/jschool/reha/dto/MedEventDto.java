package com.jschool.reha.dto;

import com.jschool.reha.enums.MedEventStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * MedEvent Dto
 *
 * @author Dmitry Sorokin
 */
@Data
public class MedEventDto implements Serializable, Comparable<MedEventDto>{

    private int idMedEvent;

    private AssignmentDto assignment;

    private MedStaffDto nurse;

    private LocalDateTime starts;

    private MedEventStatus status;

    private PatientDto patient;

    private String closedComments;

    @Override
    public int compareTo(MedEventDto o) {
        return starts.compareTo(o.getStarts());
    }

}
