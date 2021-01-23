package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.PatientDto;
import com.jschool.reha.entity.Patient;

/**
 * Helper class for entity/dto conversion
 */
public final class PatientEntityDtoHelper {
    /**
     * Converts Patient entity to PatientDto
     *
     * @param patient - entity to convert
     * @return dto - converted PatientDto
     */
    public static PatientDto entityToDto(Patient patient) {
        PatientDto dto = new PatientDto();
        dto.setIdPatient(patient.getIdPatient());
        dto.setName(patient.getName());
        dto.setLastName(patient.getLastName());
        dto.setGender(patient.getGender());
        dto.setIdInsurance(patient.getIdInsurance());
        return dto;
    }

    private PatientEntityDtoHelper(){}
}
