package com.jschool.reha.dao.interfaces;

import com.jschool.reha.entity.MedStaff;

import java.util.List;

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

    /**
     * Fetches all nurses from db
     * @return List of MedStaff Entities with role=ROLE_NURSE
     */
    List<MedStaff> getAllNurses();
}
