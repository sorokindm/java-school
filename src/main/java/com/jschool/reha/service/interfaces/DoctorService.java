package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.*;

/**
 * Service for doctor utilities
 *
 * @author Dmitry Sorokin
 */
public interface DoctorService {


    /**
     * Adds new treatment to db
     *
     * @param treatmentDto - treatment data for entity to add
     */
    void addNewTreatment(TreatmentDto treatmentDto);

    /**
     * Adds new assignment to db
     *
     * @param assignmentDto - assignment data for entity to add
     */
    void addNewAssignment(AssignmentDto assignmentDto);

    /**
     * Adds new medEvent to DB
     *
     * @param medEventDto - MedEvent data for entity to add
     */
    void addNewMedEvent(MedEventDto medEventDto);
}
