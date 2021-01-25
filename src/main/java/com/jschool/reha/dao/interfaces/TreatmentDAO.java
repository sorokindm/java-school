package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.Treatment;

import java.util.List;

/**
 * DAO Interface for Treatment Entity
 *
 * @author Dmitry Sorokin
 */
public interface TreatmentDAO {

    /**
     * Adds new Treatment entity to db
     *
     * @param treatment - entity to add
     */
    void addNewTreatment(Treatment treatment);

    /**
     * Fetches treatment from db
     *
     * @param id - treatment id in db
     * @return treatment entity from db
     */
    Treatment findTreatmentById(int id);

    /**
     * Fetches all treatments entities from db
     *
     * @return List with all treatment entities
     */
    List<Treatment> findAllTreatments();

    /**
     * Updates entity in db
     * @param treatment - Entity with update
     * @return updated Entity
     */
    Treatment update(Treatment treatment);
}
