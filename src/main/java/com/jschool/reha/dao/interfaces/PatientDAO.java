package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.Patient;

import java.util.List;

/**
 * DAO Interface for Patient Entity
 *
 * @author Dmitry Sorokin
 */
public interface PatientDAO {

    /**
     * Adds new Patient to db
     *
     * @param patient - entity to add
     */
    void addNewPatient(Patient patient);

    /**
     * Fetches patient from db
     *
     * @param id - patient id in db
     * @return Patient entity from db
     */
    Patient findPatientById(int id);

    /**
     * Fetches all patients from db
     *
     * @return List of all Patient entities
     */
    List<Patient> getAllPatients();

    /**
     * Fetches Patient from db by insurance Id
     *
     * @param insuranceId - insurance id
     * @return Patient entity
     */
    Patient findPatientByInsuranceId(String insuranceId);

    /**
     * Checks if patient exists with current insurance Id
     *
     * @param insuranceId
     */
    boolean isPatientExistWithInsuranceId(String insuranceId);
}
