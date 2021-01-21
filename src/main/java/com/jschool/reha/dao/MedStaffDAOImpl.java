package com.jschool.reha.dao;

import com.jschool.reha.entity.MedStaff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MedStaffDAOImpl implements MedStaffDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewMedStaff(MedStaff staff) {
        em.persist(staff);
    }

    @Override
    public MedStaff getMedStaffById(int id) {
        return em.find(MedStaff.class, id);
    }
}
