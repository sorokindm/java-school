package com.jschool.reha.crud.service;

import com.jschool.reha.crud.entity.Person;

import java.util.List;

/**
 * Service for user administration
 * @author Dmitry Sorokin
 */
public interface AdminService {
    public List<Person> getAllPersons();
    public Person getPersonById(int id);

}
