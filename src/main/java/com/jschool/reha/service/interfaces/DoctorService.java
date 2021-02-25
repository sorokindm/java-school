package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.entity.Assignment;

import java.util.List;

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

    /**
     * Generates medEvents based on new assignment
     *
     * @param assignment - assignment to generate from
     */
    void generateMedEventsForNewAssingment(Assignment assignment);

    /**
     * Fetches all treatments data from db
     *
     * @return List with all treatment data
     */
    List<TreatmentDto> getAllTreatments();

    /**
     * Fetches all treatments data from db for doctor id
     * @param id - doctor id
     * @return List TreatmentDto
     **/
    List<TreatmentDto> getTreatmentsForDoctorId(int id);

    /**
     * Fetches treatmentDto with given id
     *
     * @param idTreatment - treatment id
     * @return - Treatment dto with given id
     */
    TreatmentDto getTreatmentById(int idTreatment);

    /**
     * Fetches all patients dto from db
     *
     * @return List with all patients data
     */
    List<PatientDto> getAllPatients();

    /**
     * Fetches all assignments for given treatmentId
     *
     * @param treatmentId - treatment id
     * @return List of all assignments dto for given treatment
     */
    List<AssignmentDto> getAssignmentsForTreatment(int treatmentId);

    /**
     * Fetches assignment dto from db by id
     * @param idAssignment - assignment id
     * @return AssignmentDto
     */
    AssignmentDto getAssignmentById(int idAssignment);

    /**
     * Edits treatment data
     *
     * @param treatmentDto - dto with data to edit
     */
    void editTreatment(TreatmentDto treatmentDto);

    /**
     * Closes treatment
     *
     * @param treatmentDto - treatment data to close
     */
    void closeTreatment(TreatmentDto treatmentDto);

    /**
     * Edits assignment data
     *
     * @param assignmentDto - dto with data to edit
     */
    void editAssignment(AssignmentDto assignmentDto);

    /**
     * Closes assignment
     *
     * @param assignmentDto - treatment data to close
     */
    void closeAssignment(AssignmentDto assignmentDto);

    /**
     * Closes MedEvent
     *
     * @param medEventDto - medEvent data to close
     */
    void closeMedEvent(MedEventDto medEventDto);

    /**
     * Fetches all MedEventsDto for given assignmentId
     *
     * @param assignmentId - assignment id
     * @return List of MedEventDto for given assignment
     */
    List<MedEventDto> getAllMedEventsForAssignment(int assignmentId);
}
