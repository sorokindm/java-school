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
import com.jschool.reha.enums.Role;
import com.jschool.reha.service.interfaces.AdminService;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private final Logger logger= LogManager.getLogger();

    private UserDAO userDAO;

    private MedStaffDAO medStaffDAO;

    private PatientDAO patientDAO;

    PasswordEncoder passwordEncoder;

    public AdminServiceImpl(UserDAO userDAO, MedStaffDAO medStaffDAO, PatientDAO patientDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.medStaffDAO = medStaffDAO;
        this.patientDAO = patientDAO;
        this.passwordEncoder = passwordEncoder;
    }

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
        return MedStaffEntityDtoHelper.entityToDto(medStaffDAO.findMedStaffById(id));
    }

    @Override
    public PatientDto findPatientById(int id) {
        return PatientEntityDtoHelper.entityToDto(patientDAO.findPatientById(id));
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
    public String addNewPatient(UserDto userDto) {
        userDto.setRole(Role.ROLE_PATIENT);
        RandomStringGenerator pwdGenerator = new RandomStringGenerator.Builder().withinRange(50, 99)
                .build();
        String tempPassword=pwdGenerator.generate(10);
        userDto.setPassword(tempPassword);
        Patient patientEntity = new Patient();
        patientEntity.setName(userDto.getPatient().getName());
        patientEntity.setLastName(userDto.getPatient().getLastName());
        patientEntity.setGender(userDto.getPatient().getGender());
        patientEntity.setIdInsurance(userDto.getPatient().getIdInsurance());
        patientEntity.setUser(addNewUser(userDto));
        patientDAO.addNewPatient(patientEntity);
        return tempPassword;
    }
}
