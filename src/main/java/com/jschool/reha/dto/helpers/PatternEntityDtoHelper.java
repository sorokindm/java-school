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
    public static Pattern dtoToEntity(PatternDto patternDto) {
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

    public static boolean isSamePattern(Pattern pattern1, Pattern pattern2) {
        if (pattern1.getMonday().equals(pattern2.getMonday())) return false;
        if (pattern1.getTuesday().equals(pattern2.getTuesday())) return false;
        if (pattern1.getWednesday().equals(pattern2.getWednesday())) return false;
        if (pattern1.getThursday().equals(pattern2.getThursday())) return false;
        if (pattern1.getFriday().equals(pattern2.getFriday())) return false;
        if (pattern1.getSaturday().equals(pattern2.getSaturday())) return false;
        if (pattern1.getSunday().equals(pattern2.getSunday())) return false;
        if (pattern1.getMorning().equals(pattern2.getMorning())) return false;
        if (pattern1.getDay().equals(pattern2.getDay())) return false;
        if (pattern1.getEvening().equals(pattern2.getEvening())) return false;

        return true;
    }

    public static boolean isValid(PatternDto pattern) {
        boolean flag1 = false;
        boolean flag2 = false;

        if (pattern.getMorning()) flag1 = true;
        if (pattern.getDay()) flag1 = true;
        if (pattern.getEvening()) flag1 = true;

        if (pattern.getMonday()) flag2 = true;
        if (pattern.getTuesday()) flag2 = true;
        if (pattern.getWednesday()) flag2 = true;
        if (pattern.getThursday()) flag2 = true;
        if (pattern.getFriday()) flag2 = true;
        if (pattern.getSaturday()) flag2 = true;
        if (pattern.getSunday()) flag2 = true;

        return flag1&&flag2;

    }

    private PatternEntityDtoHelper() {
    }
}
