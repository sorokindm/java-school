package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.TreatmentDto;
import com.jschool.reha.entity.Treatment;

/**
 * Helper class for entity/dto conversion
 */
public final class TreatmentEntityDtoHelper {
    /**
     * Converts Treatment entity to TreatmentDto
     *
     * @param treatment - entity to convert
     * @return dto - converted TreatmentDto
     */
    public static TreatmentDto entityToDto(Treatment treatment) {
        TreatmentDto dto = new TreatmentDto();
        dto.setIdTreatment(treatment.getIdTreatment());
        dto.setDoctor(MedStaffEntityDtoHelper.entityToDto(treatment.getDoctor()));
        dto.setPatient(PatientEntityDtoHelper.entityToDto(treatment.getPatient()));
        dto.setTreatmentOpened(treatment.getTreatmentOpened());
        dto.setDiagnosis(treatment.getDiagnosis());
        dto.setOpenedComments(treatment.getOpenedComments());
        dto.setTreatmentClosed(treatment.getTreatmentClosed());
        dto.setClosedComments(treatment.getClosedComments());
        return dto;
    }

    private TreatmentEntityDtoHelper(){}
}
