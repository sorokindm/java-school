package com.jschool.reha.service;

import com.jschool.reha.dao.PersonDAO;
import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    private PersonDAO personDAO;

    @Override
    public List<UserDto> getAllUserData() {
        ArrayList<UserDto> userData=new ArrayList<>();
        List<Person> persons=personDAO.getAllPersons();
        for (Person person:persons)
        {
            UserDto dto=new UserDto();
            dto.setRole(person.getRole());
            dto.setName(person.getName());
            dto.setLastName(person.getLastName());
            dto.setUsername(person.getUsername());
            dto.setEmail(person.getEmail());
            dto.setGender(person.getGender());
            userData.add(dto);
        }

        return userData;
    }
}
