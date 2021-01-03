package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Person getPersonById(int id) {
       return this.sessionFactory.getCurrentSession().get(Person.class,id);
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return (List<Person>) this.sessionFactory.getCurrentSession().createQuery("from Person").getResultList();
    }
}
