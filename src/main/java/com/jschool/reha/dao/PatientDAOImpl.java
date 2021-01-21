package com.jschool.reha.dao;

import com.jschool.reha.entity.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatientDAOImpl implements PatientDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewPatient(Patient patient) {
        em.persist(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return em.find(Patient.class, id);
    }
}
