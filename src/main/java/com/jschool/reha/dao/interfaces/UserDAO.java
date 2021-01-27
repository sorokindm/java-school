package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.User;

import java.util.List;

/**
 * DAO Interface for Person Entity
 *
 * @author Dmitry Sorokin
 */
public interface UserDAO {

    /**
     * Fetches all person data from db
     *
     * @return List of all persons data
     */
    List<User> getAllUsers();

    /**
     * Fetches user entity from db by username
     *
     * @param username - user's username
     * @return User with given username
     */
    User findUserByUsername(String username);

    /**
     * Fetches user entity from db by id
     *
     * @param id - user's id
     * @return User with given id
     */
    User findUserById(int id);

    /**
     * Adds new user to db
     *
     * @param user - user to add
     */
    void addNewUser(User user);

}
