package com.jschool.reha.dao;

import com.jschool.reha.entity.MedEvent;

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
}
