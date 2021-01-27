package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.MedEvent;

import java.util.List;

/**
 * DAO Interface for Treatment Entity
 *
 * @author Dmitry Sorokin
 */
public interface MedEventDAO {

    /**
     * Adds new MedEvent entity to db
     *
     * @param medEvent - entity to add
     */
    void addNewMedEvent(MedEvent medEvent);

    /**
     * Fetches MedEvent from db
     *
     * @param id - MedEvent id in db
     * @return MedEvent entity from db
     */
    MedEvent getMedEventById(int id);

    /**
     * Fetches all MedEvents for given assignmentId
     *
     * @param assignmentId - assignment id
     * @return List of MedEvent entities for given assignment
     */
    List<MedEvent> getAllMedEventsForAssignment(int assignmentId);

    /**
     * Fetches all MedEvents for given patientId
     *
     * @param patientId - patient id
     * @return List of Patient entities for given assignment
     */
    List<MedEvent> getAllMedEventsForPatient(int patientId);

    /**
     * Updates entity in db
     *
     * @param medEvent - Entity with update
     * @return updated Entity
     */
    MedEvent update(MedEvent medEvent);

    /**
     * Fetches all MedEvents
     *
     * @return List of MedEvent entities
     */
    List<MedEvent> getAllMedEvents();
}
