package com.jschool.reha.service.helpers;

import com.jschool.reha.entity.Pattern;

import java.time.LocalDateTime;
import java.util.List;

public interface MedEventCalendar {
    /**
     * Generates LocalDateTime list based of pattern and quantity
     *
     * @param quantity - quantity of events
     * @param pattern  - pattern of events
     * @param start    - assignment start LocalDateTime
     * @return List of LocalDateTime for events
     */
    List<LocalDateTime> getTimeForEvents(int quantity, Pattern pattern, LocalDateTime start);
}
