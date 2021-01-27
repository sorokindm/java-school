package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.entity.MedStaff;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service to manage nurse operations
 */
public interface NurseService {

    /**
     * Finds nurse for given time, possibly depending on schedule
     *
     * @param time - time when nurse is needed
     * @return MedStaff entity
     */
    MedStaff findNurseForEvent(LocalDateTime time);

    /**
     * Fetches all medEventsFromDatabase for given nurse
     *
     * @param idMedStaff - medStaff id
     * @return List of MedEvent dtos
     */
    List<MedEventDto> findMedEventsForNurse(int idMedStaff);

    /**
     * Fetches medEvent by id from db
     * @param idMedEvent - id
     * @return dto with given id
     */
    MedEventDto getMedEventById(int idMedEvent);

    /**
     * Fetches all medEventsFromDatabase
     *
     * @return List of MedEvent dtos
     */
    List<MedEventDto> getAllMedEvents();

    /**
     * Fetches all medEventsFromDatabase for given patient
     *
     * @param idPatient - patient id
     * @return List of MedEvent dtos
     */
    List<MedEventDto> getAllMedEventsForPatient(int idPatient);

}
