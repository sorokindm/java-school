package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.MedStaff;

/**
 * DAO Interface for MedStaff Entity
 *
 * @author Dmitry Sorokin
 */
public interface MedStaffDAO {

    /**
     * Adds new MedStaff to db
     *
     * @param staff - entity to add
     */
    void addNewMedStaff(MedStaff staff);

    /**
     * Fetches medStaff from db
     *
     * @param id - medStaff id in db
     * @return MedStaff entity from db
     */
    MedStaff findMedStaffById(int id);
}
