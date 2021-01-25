package com.jschool.reha.service.helpers;

import com.jschool.reha.entity.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MedEventCalendar {
    /**
     * Generates LocalDateTime list based of pattern and quantity
     *
     * @param quantityDays - amount of days
     * @param pattern  - pattern of events
     * @param start    - assignment start LocalDateTime
     * @return List of LocalDateTime for events
     */
    List<LocalDateTime> getTimeForEvents(int quantityDays, Pattern pattern, LocalDateTime start);

    /**
     * Gets amount of events based on pattern and amount of weeks
     * @param start - start of calculations
     * @param quantityDays - amount of days
     * @param pattern - pattern
     * @return int - amount of events
     */
    int getNumberOfEvents(LocalDate start, int quantityDays, Pattern pattern);
}
