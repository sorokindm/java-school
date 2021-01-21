package com.jschool.reha.service;

import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.MedStaff;

import java.util.List;

/**
 * Service for user administration
 * @author Dmitry Sorokin
 */
public interface AdminService {
    /**
     * Fetches all users data from db
     * @return List of all users int the UserDto format
     */
    List<UserDto> getAllUserData();

    void addNewMedStaff(MedStaff staff);
}
