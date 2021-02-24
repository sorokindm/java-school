package com.jschool.reha.service.interfaces;

import com.jschool.reha.dto.RestMedEventDto;

import java.util.List;

/**
 * Service for screen web service
 */
public interface RestService {

    /**
     * Fetches list of med event dto's
     */
    List<RestMedEventDto> getCurrentMedEvents();
}
