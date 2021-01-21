package com.jschool.reha.dao;

import com.jschool.reha.entity.Patient;

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
    Patient getPatientById(int id);
}
