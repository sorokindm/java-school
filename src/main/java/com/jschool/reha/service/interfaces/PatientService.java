package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.MedEventDto;

import java.util.List;

/**
 * Service for patient
 *
 * @author Dmitry Sorokin
 */
public interface PatientService {

    /**
     * Fetches all SCHEDULED events for given patient id
     *
     * @param patientId - patient id
     * @return List of MedEventDto for given id
     */
    List<MedEventDto> getAllActiveMedEventsForGivenPatient(int patientId);

}
