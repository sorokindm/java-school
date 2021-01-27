package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.PatternDAO;
import com.jschool.reha.entity.Pattern;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatternDAOImpl implements PatternDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Pattern addNewPattern(Pattern pattern) {
        em.persist(pattern);
        return pattern;
    }

    @Override
    public Pattern getPatternById(int id) {
        return em.find(Pattern.class, id);
    }
}
