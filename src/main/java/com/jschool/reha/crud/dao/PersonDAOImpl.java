package com.jschool.reha.crud.dao;

import com.jschool.reha.crud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Implementation of PersonDAO. DB access with jpa
 * @author Dmitry Sorokin
 */
@Repository
public class PersonDAOImpl implements PersonDAO{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Person> getAllPersons() {
        return this.entityManagerFactory.createEntityManager().createQuery("from Person").getResultList();
    }
}
