package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.AssignmentDto;
import com.jschool.reha.entity.Assignment;

/**
 * Helper class for entity/dto conversion
 */
public final class AssignmentEntityDtoHelper {
    /**
     * Converts Assignment entity to AssignmentDto
     *
     * @param assignment - entity to convert
     * @return dto - converted AssignmentDto
     */
    public static AssignmentDto entityToDto(Assignment assignment) {
        AssignmentDto dto = new AssignmentDto();
        dto.setIdAssignment(assignment.getIdAssignment());
        dto.setTreatment(TreatmentEntityDtoHelper.entityToDto(assignment.getTreatment()));
        dto.setType(assignment.getType());
        dto.setName(assignment.getName());
        dto.setDosage(assignment.getDosage());
        dto.setQuantity(assignment.getQuantity());
        dto.setPattern(assignment.getPattern());
        dto.setAssignmentEndDate(assignment.getAssignmentStartDate());
        dto.setAssignmentEndDate(assignment.getAssignmentEndDate());
        dto.setClosedComments(assignment.getClosedComments());
        return dto;
    }

    private AssignmentEntityDtoHelper(){}
}
