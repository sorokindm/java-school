package com.jschool.reha.crud.service;

import com.jschool.reha.crud.dto.UserDto;

import java.util.List;

/**
 * Service for user administration
 * @author Dmitry Sorokin
 */
public interface AdminService {
    public List<UserDto> getAllUserData();
}
