package com.jschool.reha.dao.implementation;

import com.jschool.reha.dao.interfaces.UserDAO;
import com.jschool.reha.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private final Logger logger = LogManager.getLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select user from User user").getResultList();
    }

    @Override
    public User findUserByUsername(String username) {
        return (User) em.createQuery("select user from User user where user.username= :username").setParameter("username",username).getSingleResult();
    }

    @Override
    public boolean isUserExist(String username) {
        List<User> list=em.createQuery("select user from User user where user.username= :username").setParameter("username",username).getResultList();
        if (list.isEmpty()) return false;
        return true;
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void addNewUser(User user) {
        logger.info("Adding new user to db",user);
        em.persist(user);
    }
}
