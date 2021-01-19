package com.jschool.reha.dao;

import com.jschool.reha.entity.User;

import java.util.List;

/**
 * DAO Interface for Person Entity
 * @author Dmitry Sorokin
 */
public interface PersonDAO {

    /**
     * Fetches all person data from db
     * @return List of all persons data
     */
    List<User> getAllPersons();
}
