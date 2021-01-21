package com.jschool.reha.service;

import com.jschool.reha.dao.MedStaffDAO;
import com.jschool.reha.dao.UserDAO;
import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.MedStaff;
import com.jschool.reha.entity.User;
import com.jschool.reha.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Admin service. Handles user data.
 * @author Dmitry Sorokin
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MedStaffDAO medStaffDAO;

    @Override
    public List<UserDto> getAllUserData() {
        ArrayList<UserDto> userData=new ArrayList<>();
        List<User> users = userDAO.getAllUsers();
        for (User user : users)
        {
            UserDto dto=new UserDto();
            dto.setRole(user.getRole());
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            if (dto.getRole()== Role.ROLE_PATIENT)
            {
                dto.setName(user.getPatient().getName());
                dto.setLastName(user.getPatient().getLastName());
                dto.setGender(user.getPatient().getGender());
            }
            else
            {
                dto.setName(user.getMedStaff().getName());
                dto.setLastName(user.getMedStaff().getLastName());
                dto.setGender(user.getMedStaff().getGender());
            }
            userData.add(dto);
        }

        return userData;
    }

    @Override
    public void addNewMedStaff(MedStaff staff) {
        User user=staff.getUser();
        user.setCreateTime(LocalDateTime.now());
        user.setEnabled(true);
        userDAO.addNewUser(user);
        medStaffDAO.addNewMedStaff(staff);
    }
}
