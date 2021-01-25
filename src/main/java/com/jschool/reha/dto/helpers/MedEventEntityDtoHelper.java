package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.entity.MedEvent;

/**
 * Helper class for entity/dto conversion
 */
public final class MedEventEntityDtoHelper {

    /**
     * Converts MedEvent entity to MedEventDto
     *
     * @param medEvent - entity to convert
     * @return dto - converted MedEventDto
     */
    public static MedEventDto entityToDto(MedEvent medEvent) {
        MedEventDto dto = new MedEventDto();
        dto.setPatient(PatientEntityDtoHelper.entityToDto(medEvent.getPatient()));
        dto.setAssignment(AssignmentEntityDtoHelper.entityToDto(medEvent.getAssignment()));
        dto.setIdMedEvent(medEvent.getIdMedEvent());
        dto.setNurse(MedStaffEntityDtoHelper.entityToDto(medEvent.getNurse()));
        dto.setStarts(medEvent.getStarts());
        dto.setStatus(medEvent.getStatus());
        dto.setClosedComments(medEvent.getClosedComments());
        return dto;
    }

    private MedEventEntityDtoHelper() {
    }
}
