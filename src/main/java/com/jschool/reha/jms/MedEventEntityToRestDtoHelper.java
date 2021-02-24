package com.jschool.reha.jms;

import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.entity.MedEvent;

/**
 * Helper class for entity to rest dto conversion
 */
public final class MedEventEntityToRestDtoHelper {
    private MedEventEntityToRestDtoHelper() {
        
    }

    /**
     * Converts entity to dto
     * @param event -MedEvent entity to convert
     * @return dto for rest service
     */
    public static RestMedEventDto entityToDto(MedEvent event) {
        RestMedEventDto dto=new RestMedEventDto();
        dto.setIdMedEvent(event.getIdMedEvent());
        dto.setNurseName(event.getNurse().getName());
        dto.setNurseLastName(event.getNurse().getLastName());
        dto.setPatientName(event.getPatient().getName());
        dto.setPatientLastName(event.getPatient().getLastName());
        dto.setStatus(event.getStatus().name());
        dto.setStarts(event.getStarts());
        return dto;
    }
}
