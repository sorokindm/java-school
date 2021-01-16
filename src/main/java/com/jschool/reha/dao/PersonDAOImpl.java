package com.jschool.reha.dao;

import com.jschool.reha.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of PersonDAO. DB access with jpa
 * @author Dmitry Sorokin
 */
@Repository
public class PersonDAOImpl implements PersonDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> getAllPersons() {
        return em.createQuery("select p from Person p").getResultList();
    }
}
