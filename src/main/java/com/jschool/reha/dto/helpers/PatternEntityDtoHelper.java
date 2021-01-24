package com.jschool.reha.dto.helpers;

import com.jschool.reha.dto.PatternDto;
import com.jschool.reha.entity.Pattern;

/**
 * Helper class for entity/dto conversion
 */
public final class PatternEntityDtoHelper {

    /**
     * Converts Pattern entity to PatternDto
     *
     * @param pattern - entity to convert
     * @return dto - converted PatternDto
     */
    public static PatternDto entityToDto(Pattern pattern) {
        PatternDto dto = new PatternDto();
        dto.setMorning(pattern.getMorning());
        dto.setDay(pattern.getDay());
        dto.setEvening(pattern.getEvening());
        dto.setMonday(pattern.getMonday());
        dto.setTuesday(pattern.getTuesday());
        dto.setWednesday(pattern.getWednesday());
        dto.setThursday(pattern.getThursday());
        dto.setFriday(pattern.getFriday());
        dto.setSaturday(pattern.getSaturday());
        dto.setSunday(pattern.getSunday());
        return dto;
    }

    /**
     * Converts PatternDto to Pattern entity
     *
     * @param patternDto - dto to convert
     * @return patter - converted Pattern entity
     */
    public static Pattern dtoToEntity(PatternDto patternDto){
        Pattern pattern = new Pattern();
        pattern.setMorning(patternDto.getMorning());
        pattern.setDay(patternDto.getDay());
        pattern.setEvening(patternDto.getEvening());
        pattern.setMonday(patternDto.getMonday());
        pattern.setTuesday(patternDto.getTuesday());
        pattern.setWednesday(patternDto.getWednesday());
        pattern.setThursday(patternDto.getThursday());
        pattern.setFriday(patternDto.getFriday());
        pattern.setSaturday(patternDto.getSaturday());
        pattern.setSunday(patternDto.getSunday());
        return pattern;
    }

    private PatternEntityDtoHelper(){}
}
