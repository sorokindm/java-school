package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;

import java.util.List;

public interface PersonDAO {

    /**
     * Fetches one person from DB by id
     *
     * @param id Persons id in DB
     * @return Person
     */
    public Person getPersonById(int id);

    /**
     * Fetches all Person Data From DB
     *
     * @return List<Person>
     */
    public List<Person> getAllPersons();
}
