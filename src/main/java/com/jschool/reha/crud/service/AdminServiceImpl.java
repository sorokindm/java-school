package com.jschool.reha.crud.service;

import com.jschool.reha.crud.dao.PersonDAO;
import com.jschool.reha.crud.dto.UserDto;
import com.jschool.reha.crud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
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
