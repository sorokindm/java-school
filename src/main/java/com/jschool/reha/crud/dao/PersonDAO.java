package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;

import java.util.List;

public interface PersonDAO {
    /*
        Fetches all persons data from a DB
     */
    public List<Person> getAllPersons();
}
