package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;

import java.util.List;

//TODO 12.01.2021 matmalik: javadoc
public interface PersonDAO {
    /*
        Fetches all persons data from a DB
     */
    public List<Person> getAllPersons();
    //TODO 12.01.2021 matmalik: all methods in interface are abstract and public by default
}
