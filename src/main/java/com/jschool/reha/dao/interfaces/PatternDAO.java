package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.Pattern;

/**
 * DAO Interface for Pattern Entity
 *
 * @author Dmitry Sorokin
 */
public interface PatternDAO {

    /**
     * Adds new Pattern entity to db
     *
     * @param pattern - entity to add
     * @return managed Pattern entity
     */
    Pattern addNewPattern(Pattern pattern);

    /**
     * Fetches Pattern from db
     *
     * @param id - Pattern id in db
     * @return Pattern entity from db
     */
    Pattern getPatternById(int id);
}
