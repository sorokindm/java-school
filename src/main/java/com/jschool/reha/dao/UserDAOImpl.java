package com.jschool.reha.dao;

import com.jschool.reha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of PersonDAO. DB access with jpa
 * @author Dmitry Sorokin
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select p from User p").getResultList();
    }

    @Override
    public void addNewUser(User user) {
        em.persist(user);
    }
}
