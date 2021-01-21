package com.jschool.reha.service;

import com.jschool.reha.entity.Assignment;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.entity.Treatment;

/**
 * Service for doctor utilities
 *
 * @author Dmitry Sorokin
 */
public interface DoctorService {
    /**
     * Adds new patient to db
     *
     * @param patient - patient entity to add
     */
    void addNewPatient(Patient patient);

    /**
     * Adds new treatment to db
     *
     * @param treatment - treatment entity to add
     */
    void addNewTreatment(Treatment treatment);

    /**
     * Adds new assignment to db
     *
     * @param assignment - assignment entity to add
     */
    void addNewAssignment(Assignment assignment);

    /**
     * Adds new medEvent to DB
     *
     * @param medEvent - MedEvent entity to add
     */
    void addNewMedEvent(MedEvent medEvent);
}
