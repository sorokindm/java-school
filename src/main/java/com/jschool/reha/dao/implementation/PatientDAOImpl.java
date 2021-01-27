package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.PatientDAO;
import com.jschool.reha.entity.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewPatient(Patient patient) {
        em.persist(patient);
    }

    @Override
    public Patient findPatientById(int id) {
        return em.find(Patient.class, id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return em.createQuery("select p from Patient p").getResultList();
    }
}
