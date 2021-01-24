package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.AssignmentDAO;
import com.jschool.reha.entity.Assignment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AssignmentDAOImpl implements AssignmentDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addNewAssignment(Assignment assignment) {
        em.persist(assignment);
    }

    @Override
    public Assignment getAssignmentById(int id) {
        return em.find(Assignment.class, id);
    }

    @Override
    public List<Assignment> getAssignmentsForTreatment(int treatmentId) {
        return em.createQuery("select assignment from Assignment assignment " +
                "where assignment.treatment.idTreatment= :treatmentId").setParameter("treatmentId", treatmentId)
                .getResultList();
    }
}
