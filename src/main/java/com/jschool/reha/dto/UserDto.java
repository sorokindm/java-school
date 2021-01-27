package com.jschool.reha.dto;

import com.jschool.reha.dto.validation.PatientConstraint;
import com.jschool.reha.dto.validation.UsernameConstraint;
import com.jschool.reha.enums.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Dto for User
 */
@Data
@NoArgsConstructor
public class UserDto {

    private int idUser;

    @NotNull(message = "Username is required")
    @Size(min=6,max=30, message = "Username must be between 6 and 30 characters")
    @UsernameConstraint
    private String username;

    @NotNull
    private String password;

    private Role role;

    @NotNull
    private String email;

    private LocalDateTime createTime;

    private boolean enabled;

    private MedStaffDto medStaff;

    @PatientConstraint
    private PatientDto patient;

}
