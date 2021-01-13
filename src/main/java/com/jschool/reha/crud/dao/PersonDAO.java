package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;

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
    List<Person> getAllPersons();
}
