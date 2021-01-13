package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO 12.01.2021 matmalik: javadoc
@Repository
public class PersonDAOImpl implements PersonDAO{

    //TODO 12.01.2021 matmalik: Please check my comment in HibernateConfig.class and use here em
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) this.sessionFactory.getCurrentSession().createQuery("from Person").getResultList();
    }
}
