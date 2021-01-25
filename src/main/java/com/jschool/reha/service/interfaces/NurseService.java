package com.jschool.reha.service.interfaces;

import com.jschool.reha.entity.MedStaff;

import java.time.LocalDateTime;

/**
 * Service to manage nurse operations
 */
public interface NurseService {

    /**
     * Finds nurse for given time, possibly depending on schedule
     * @param time - time when nurse is needed
     * @return MedStaff entity
     */
    MedStaff findNurseForEvent(LocalDateTime time);
}
