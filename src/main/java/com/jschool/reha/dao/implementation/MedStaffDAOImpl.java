package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.MedStaffDAO;
import com.jschool.reha.entity.MedStaff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MedStaffDAOImpl implements MedStaffDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewMedStaff(MedStaff staff) {
        em.persist(staff);
    }

    @Override
    public MedStaff findMedStaffById(int id) {
        return em.find(MedStaff.class, id);
    }

    @Override
    public List<MedStaff> getAllNurses() {
        return em.createQuery("select n from MedStaff n where n.user.role='ROLE_NURSE'").getResultList();
    }
}
