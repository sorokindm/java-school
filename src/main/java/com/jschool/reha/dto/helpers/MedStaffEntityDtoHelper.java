package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.MedStaffDto;
import com.jschool.reha.entity.MedStaff;

/**
 * Helper class for entity/dto conversion
 */
public final class MedStaffEntityDtoHelper {
    /**
     * Converts MedStaff entity to MedStaffDto
     *
     * @param medStaff - entity to convert
     * @return dto - converted MedStaffDto
     */
    public static MedStaffDto entityToDto(MedStaff medStaff) {
        if (medStaff==null) return null;
        MedStaffDto dto = new MedStaffDto();
        dto.setIdMedStaff(medStaff.getIdMedStaff());
        dto.setName(medStaff.getName());
        dto.setLastName(medStaff.getLastName());
        dto.setGender(medStaff.getGender());
        dto.setSpecialty(medStaff.getSpecialty());
        return dto;
    }

    private MedStaffEntityDtoHelper(){}
}
