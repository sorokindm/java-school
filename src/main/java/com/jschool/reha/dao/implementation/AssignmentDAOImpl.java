package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.AssignmentDAO;
import com.jschool.reha.entity.Assignment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO {

    private final Logger logger = LogManager.getLogger();

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewAssignment(Assignment assignment) {
        logger.info("Adding new assignment to db",assignment);
        em.persist(assignment);
    }

    @Override
    public Assignment getAssignmentById(int id) {
        logger.info("Fetching assignment from db with id:"+id);
        return em.find(Assignment.class, id);
    }

    @Override
    public List<Assignment> getAssignmentsForTreatment(int treatmentId) {
        logger.info("Fetching assignment from db with treatment id:"+treatmentId);
        return em.createQuery("select assignment from Assignment assignment " +
                "where assignment.treatment.idTreatment= :treatmentId").setParameter("treatmentId", treatmentId)
                .getResultList();
    }

    @Override
    public Assignment update(Assignment assignment) {
        return em.merge(assignment);
    }
}
