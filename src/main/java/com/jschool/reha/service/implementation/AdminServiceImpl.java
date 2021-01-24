package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedStaffDAO;
import com.jschool.reha.dao.interfaces.PatientDAO;
import com.jschool.reha.dao.interfaces.UserDAO;
import com.jschool.reha.dto.MedStaffDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.UserDto;
import com.jschool.reha.dto.helpers.MedStaffEntityDtoHelper;
import com.jschool.reha.dto.helpers.PatientEntityDtoHelper;
import com.jschool.reha.dto.helpers.UserEntityDtoHelper;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.entity.Patient;
import com.jschool.reha.entity.User;
import com.jschool.reha.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Admin service. Handles user data.
 *
 * @author Dmitry Sorokin
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MedStaffDAO medStaffDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUserData() {
        ArrayList<UserDto> userData = new ArrayList<>();
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            UserDto dto = UserEntityDtoHelper.entityToDto(user);
            userData.add(dto);
        }
        return userData;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return UserEntityDtoHelper.entityToDto(userDAO.findUserByUsername(username));
    }

    @Override
    public MedStaffDto findMedStaffByUsername(String username) {
        return MedStaffEntityDtoHelper.entityToDto(userDAO.findUserByUsername(username).getMedStaff());
    }

    @Override
    public PatientDto findPatientByUsername(String username) {
        return PatientEntityDtoHelper.entityToDto(userDAO.findUserByUsername(username).getPatient());
    }

    @Override
    public UserDto findUserById(int id) {
        return UserEntityDtoHelper.entityToDto(userDAO.findUserById(id));
    }

    @Override
    public MedStaffDto findMedStaffById(int id) {
        return MedStaffEntityDtoHelper.entityToDto(userDAO.findUserById(id).getMedStaff());
    }

    @Override
    public PatientDto findPatientById(int id) {
        return PatientEntityDtoHelper.entityToDto(userDAO.findUserById(id).getPatient());
    }

    @Override
    public User addNewUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setCreateTime(LocalDateTime.now());
        user.setRole(userDto.getRole());
        user.setEnabled(true);
        userDAO.addNewUser(user);
        return user;
    }

    @Override
    public MedStaff addNewMedStaff(UserDto userDto) {
        MedStaff medStaffEntity = new MedStaff();
        medStaffEntity.setName(userDto.getMedStaff().getName());
        medStaffEntity.setLastName(userDto.getMedStaff().getLastName());
        medStaffEntity.setGender(userDto.getMedStaff().getGender());
        medStaffEntity.setSpecialty(userDto.getMedStaff().getSpecialty());
        medStaffEntity.setUser(addNewUser(userDto));

        medStaffDAO.addNewMedStaff(medStaffEntity);
        return medStaffEntity;
    }

    @Override
    public Patient addNewPatient(UserDto userDto) {
        Patient patientEntity = new Patient();
        patientEntity.setName(userDto.getPatient().getName());
        patientEntity.setLastName(userDto.getPatient().getLastName());
        patientEntity.setGender(userDto.getPatient().getGender());
        patientEntity.setIdInsurance(userDto.getPatient().getIdInsurance());
        patientEntity.setUser(addNewUser(userDto));
        patientDAO.addNewPatient(patientEntity);
        return patientEntity;
    }
}
