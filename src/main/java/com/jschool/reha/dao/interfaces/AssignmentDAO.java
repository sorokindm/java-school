package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.Assignment;

/**
 * DAO Interface for Assignment Entity
 *
 * @author Dmitry Sorokin
 */
public interface AssignmentDAO {

    /**
     * Adds new Assignment to db
     *
     * @param assignment - entity to add
     */
    void addNewAssignment(Assignment assignment);

    /**
     * Fetches assignment from db
     *
     * @param id - assignment id in db
     * @return assignment entity from db
     */
    Assignment getAssignmentById(int id);


}
