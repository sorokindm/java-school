package com.jschool.reha.crud.dto;

import com.jschool.reha.crud.enums.Gender;
import com.jschool.reha.crud.enums.Role;
import lombok.Data;

/**
 * Dto
 */
@Data
public class UserDto {
    private String username;
    private String email;
    private String name;
    private String lastName;
    private Gender gender;
    private Role role;
}
