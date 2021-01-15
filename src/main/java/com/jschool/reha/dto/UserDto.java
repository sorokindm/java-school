package com.jschool.reha.dto;

import com.jschool.reha.enums.Gender;
import com.jschool.reha.enums.Role;
import lombok.Data;
/**
 * Dto for User
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
