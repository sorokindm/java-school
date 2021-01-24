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
}
