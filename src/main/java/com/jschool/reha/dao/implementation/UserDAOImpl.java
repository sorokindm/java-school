package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.UserDAO;
import com.jschool.reha.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of PersonDAO. DB access with jpa
 *
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
    public User findUserByUsername(String username) {
        return (User) em.createQuery("select u from User u where u.username = :username").getSingleResult();
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void addNewUser(User user) {
        em.persist(user);
    }
}
