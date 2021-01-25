package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.MedEventDAO;
import com.jschool.reha.entity.MedEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public List<MedEvent> getAllMedEventsForAssignment(int assignmentId) {
        return em.createQuery("select medEvent from MedEvent medEvent where medEvent.assignment.idAssignment= :assignmentId")
                .setParameter("assignmentId",assignmentId).getResultList();
    }

    @Override
    public MedEvent update(MedEvent medEvent) {
        return em.merge(medEvent);
    }
}
