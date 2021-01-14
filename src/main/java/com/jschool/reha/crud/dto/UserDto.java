package com.jschool.reha.crud.dto;

import com.jschool.reha.crud.enums.Gender;
import com.jschool.reha.crud.enums.Role;
import lombok.Data;
//TODO 13.01.2021 matmalik: nice =). Please be precise (e.g DTO for User)
// or you can avoid comments if everything is clear
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
