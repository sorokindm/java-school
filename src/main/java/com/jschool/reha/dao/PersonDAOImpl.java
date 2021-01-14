package com.jschool.reha.dao;

import com.jschool.reha.entity.Person;
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
        return entityManagerFactory.createEntityManager().createQuery("select p from Person p").getResultList();
    }
}
