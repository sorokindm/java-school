package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.TreatmentDAO;
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
    public Treatment findTreatmentById(int id) {
        return em.find(Treatment.class,id);
    }
}
