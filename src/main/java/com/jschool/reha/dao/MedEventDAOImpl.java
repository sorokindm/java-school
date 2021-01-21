package com.jschool.reha.dao;

import com.jschool.reha.entity.MedEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MedEventDAOImpl implements MedEventDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewMedEvent(MedEvent medEvent) {
        em.persist(medEvent);
    }

    @Override
    public MedEvent getMedEventById(int id) {
        return em.find(MedEvent.class, id);
    }
}
