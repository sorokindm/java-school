package com.jschool.reha.dao;

import com.jschool.reha.entity.Treatment;

/**
 * DAO Interface for Treatment Entity
 *
 * @author Dmitry Sorokin
 */
public interface TreatmentDAO {

    /**
     * Adds new Treatment entity to db
     *
     * @param treament - entity to add
     */
    void addNewTreatment(Treatment treament);

    /**
     * Fetches treatment from db
     *
     * @param id - treatment id in db
     * @return treatment entity from db
     */
    Treatment getTreatmentById(int id);
}
