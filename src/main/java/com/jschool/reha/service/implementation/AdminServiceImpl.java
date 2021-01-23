package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedStaffDAO;
import com.jschool.reha.dao.interfaces.PatientDAO;
import com.jschool.reha.dao.interfaces.UserDAO;
import com.jschool.reha.dto.MedStaffDto;
import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.dto.UserDto;
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
            UserDto dto = new UserDto(user);
            userData.add(dto);
        }
        return userData;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return new UserDto(userDAO.findUserByUsername(username));
    }

    @Override
    public MedStaffDto findMedStaffByUsername(String username) {
        return new MedStaffDto(userDAO.findUserByUsername(username).getMedStaff());
    }

    @Override
    public PatientDto findPatientByUsername(String username) {
        return new PatientDto(userDAO.findUserByUsername(username).getPatient());
    }

    @Override
    public UserDto findUserById(int id) {
        return new UserDto(userDAO.findUserById(id));
    }

    @Override
    public MedStaffDto findMedStaffById(int id) {
        return new MedStaffDto(userDAO.findUserById(id).getMedStaff());
    }

    @Override
    public PatientDto findPatientById(int id) {
        return new PatientDto(userDAO.findUserById(id).getPatient());
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
    public MedStaff addNewMedStaff(UserDto userDto, MedStaffDto medStaffDto) {
        MedStaff medStaffEntity = new MedStaff();
        medStaffEntity.setName(medStaffDto.getName());
        medStaffEntity.setLastName(medStaffDto.getLastName());
        medStaffEntity.setGender(medStaffDto.getGender());
        medStaffEntity.setSpecialty(medStaffDto.getSpecialty());
        medStaffEntity.setUser(addNewUser(userDto));

        medStaffDAO.addNewMedStaff(medStaffEntity);
        return medStaffEntity;
    }

    @Override
    public Patient addNewPatient(UserDto userDto, PatientDto patientDto) {
        Patient patientEntity = new Patient();
        patientEntity.setName(patientDto.getName());
        patientEntity.setLastName(patientDto.getLastName());
        patientEntity.setGender(patientDto.getGender());
        patientEntity.setIdInsurance(patientDto.getIdInsurance());
        patientEntity.setUser(addNewUser(userDto));
        patientDAO.addNewPatient(patientEntity);
        return patientEntity;
    }
}
