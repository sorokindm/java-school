package com.jschool.reha.dto;

import com.jschool.reha.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Dto for User
 */
@Data
@NoArgsConstructor
public class UserDto {

    private int idUser;

    private String username;

    private String password;

    private Role role;

    private String email;

    private LocalDateTime createTime;

    private boolean enabled;

    private MedStaffDto medStaff;

    private PatientDto patient;

}
