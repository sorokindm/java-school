package com.jschool.reha.crud.service;

import com.jschool.reha.crud.dao.PersonDAO;
import com.jschool.reha.crud.dao.PersonDAOImpl;
import com.jschool.reha.crud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }
}
