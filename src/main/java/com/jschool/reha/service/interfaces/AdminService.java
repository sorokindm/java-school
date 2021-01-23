package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.MedStaffDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.entity.User;

import java.util.List;

/**
 * Service for user administration
 *
 * @author Dmitry Sorokin
 */
public interface AdminService {
    /**
     * Fetches all users data from db
     *
     * @return List of all users int the UserDto format
     */
    List<UserDto> getAllUserData();

    /**
     * Fetches user dto from db by username
     *
     * @param username - user's username
     * @return UserDto with given username
     */
    UserDto findUserByUsername(String username);

    /**
     * Fetches MedStaff dto from db by username
     *
     * @param username - user's username
     * @return MedStaffDto with given username
     */
    MedStaffDto findMedStaffByUsername(String username);

    /**
     * Fetches Patient dto from db by username
     *
     * @param username - Patient's username
     * @return PatientDto with given username
     */
    PatientDto findPatientByUsername(String username);

    /**
     * Fetches user dto from db by id
     *
     * @param id - user's id
     * @return UserDto with given id
     */
    UserDto findUserById(int id);

    /**
     * Fetches MedStaff dto from db by id
     *
     * @param id - user's id
     * @return MedStaffDto with given id
     */
    MedStaffDto findMedStaffById(int id);

    /**
     * Fetches Patient dto from db by id
     *
     * @param id - Patient's id
     * @return PatientDto with given id
     */
    PatientDto findPatientById(int id);

    /**
     * Adds new medStaff and user to db
     *
     * @param userDto - user and medStaff data to add
     * @return Managed MedStaff entity
     */
    MedStaff addNewMedStaff(UserDto userDto, MedStaffDto medStaffDto);

    /**
     * Adds new patient and user to db
     *
     * @param userDto - patient and user data for entity to add
     * @return Managed Patient entity
     */
    Patient addNewPatient(UserDto userDto, PatientDto patientDto);

    /**
     * Adds new user to db
     *
     * @param userDto - user data to add
     * @return Managed User entity
     */
    User addNewUser(UserDto userDto);

}
