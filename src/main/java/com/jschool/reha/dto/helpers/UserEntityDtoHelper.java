package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.UserDto;
import com.jschool.reha.entity.User;

/**
 * Helper class for entity/dto conversion
 */
public final class UserEntityDtoHelper {

    /**
     * Converts User entity to UserDto
     *
     * @param user - entity to convert
     * @return dto - converted UserDto
     */
    public static UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        dto.setIdUser(user.getIdUser());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setEmail(user.getEmail());
        dto.setCreateTime(user.getCreateTime());
        dto.setEnabled(user.isEnabled());
        dto.setMedStaff(MedStaffEntityDtoHelper.entityToDto(user.getMedStaff()));
        dto.setPatient(PatientEntityDtoHelper.entityToDto(user.getPatient()));
        return dto;
    }

    private UserEntityDtoHelper(){}
}
