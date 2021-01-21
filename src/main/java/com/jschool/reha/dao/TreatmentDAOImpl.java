package com.jschool.reha.dao;

import com.jschool.reha.entity.Treatment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewTreatment(Treatment treatment) {
        em.persist(treatment);
    }

    @Override
    public Treatment getTreatmentById(int id) {
        return em.find(Treatment.class,id);
    }
}
