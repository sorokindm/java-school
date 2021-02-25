package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.TreatmentDAO;
import com.jschool.reha.entity.Treatment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TreatmentDAOImpl implements TreatmentDAO {

    private final Logger logger = LogManager.getLogger();

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewTreatment(Treatment treatment) {
        logger.info("Adding new treatment to db",treatment);
        em.persist(treatment);
    }

    @Override
    public Treatment findTreatmentById(int id) {
        return em.find(Treatment.class,id);
    }

    @Override
    public List<Treatment> findAllTreatments() {
        return em.createQuery("select t from Treatment t").getResultList();
    }

    @Override
    public List<Treatment> findTreatmentsForDoctorId(int id) {
        return em.createQuery("select t from Treatment t where t.doctorId= :id").
                setParameter("id",id).
                getResultList();
    }

    @Override
    public Treatment update(Treatment treatment) {
        return em.merge(treatment);
    }
}
