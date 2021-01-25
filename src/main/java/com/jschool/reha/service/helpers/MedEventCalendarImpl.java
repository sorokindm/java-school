package com.jschool.reha.service.helpers;

import com.jschool.reha.entity.Pattern;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class that manages date-time calculations regarding MedEvent creation
 */
@Component
public class MedEventCalendarImpl implements MedEventCalendar {

    @Override
    public List<LocalDateTime> getTimeForEvents(int quantityDays, Pattern pattern, LocalDateTime start) {
        ArrayList<LocalDateTime> events = new ArrayList<>();
        LocalDateTime time = start;

        //All events are planned for the next day minimum
        time = time.plusDays(1).withHour(0);

        int quantityEvents=getNumberOfEvents(start.toLocalDate(),quantityDays,pattern);
        for (int i = 0; i < quantityEvents; i++) {
            time = findNextEventTimeFromNow(pattern, time);
            events.add(time);
        }
        return events;
    }


    private boolean isMorning(int hour) {
        return (hour >= 6 && hour <= 13);
    }

    private boolean isDay(int hour) {
        return (hour > 13 && hour < 17);
    }

    private boolean isEvening(int hour) {
        return (hour >= 17);
    }


    private LocalDateTime findNextEventTimeFromNow(Pattern pattern, LocalDateTime now) {

        List<DayOfWeek> daysPattern = getListFromPattern(pattern);
        LocalDateTime nextEvent = null;
        for (int i = 0; i < 7; i++) {
            DayOfWeek day = now.plusDays(i).getDayOfWeek();

            if (daysPattern.contains(day)) {
                LocalDate nextDate = now.toLocalDate().plusDays(i);
                int hour = now.getHour();

                //If now is evening find next possible day from pattern
                if (isEvening(hour)) {
                    nextDate = findNextPossibleDay(daysPattern, nextDate);
                }
                hour = findNextPossibleHour(hour,pattern);
                nextEvent = LocalDateTime.of(nextDate, LocalTime.of(hour, 0));
            }
        }

        if (nextEvent == null) {
            throw new RuntimeException();
            //TODO Should never happen. Add logging
        }
        return nextEvent;
    }

    private LocalDate findNextPossibleDay(List<DayOfWeek> daysPattern, LocalDate currentDay) {
        int index = daysPattern.indexOf(currentDay.getDayOfWeek());
        if (daysPattern.size() == index + 1) {
            index = 0;
        } else {
            index++;
        }
        return currentDay.with(TemporalAdjusters.next(daysPattern.get(index)));
    }

    public int findNextPossibleHour(int hour, Pattern pattern) {
        if (isEvening(hour)) hour=0;
        if (isMorning(hour)&& pattern.getDay()) return 13;
        if (isDay(hour)&&pattern.getEvening()) return 17;
        if (pattern.getMorning()) return 9;
        if (pattern.getDay()) return 13;
        if (pattern.getEvening()) return 17;
        throw new IllegalArgumentException("Hour is out of range [0.24] or Pattern is empty");
    }

    private List<DayOfWeek> getListFromPattern(Pattern pattern) {
        ArrayList<DayOfWeek> days = new ArrayList<>();

        if (Boolean.TRUE.equals(pattern.getMonday())) days.add(DayOfWeek.MONDAY);
        if (Boolean.TRUE.equals(pattern.getTuesday())) days.add(DayOfWeek.TUESDAY);
        if (Boolean.TRUE.equals(pattern.getWednesday())) days.add(DayOfWeek.WEDNESDAY);
        if (Boolean.TRUE.equals(pattern.getThursday())) days.add(DayOfWeek.THURSDAY);
        if (Boolean.TRUE.equals(pattern.getFriday())) days.add(DayOfWeek.FRIDAY);
        if (Boolean.TRUE.equals(pattern.getSaturday())) days.add(DayOfWeek.SATURDAY);
        if (Boolean.TRUE.equals(pattern.getSunday())) days.add(DayOfWeek.SUNDAY);

        return days;
    }
    @Override
    public int getNumberOfEvents(LocalDate start,int quantityDays,Pattern pattern) {
        int days=0;
        int eventsPerDay=0;

        for (int i=0;i<quantityDays;i++) {
            LocalDate day=start.plusDays(i);
            if (day.getDayOfWeek()==DayOfWeek.MONDAY && pattern.getMonday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.TUESDAY && pattern.getTuesday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.WEDNESDAY && pattern.getWednesday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.THURSDAY && pattern.getThursday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.FRIDAY && pattern.getFriday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.SATURDAY && pattern.getSaturday()) days++;
            if (day.getDayOfWeek()==DayOfWeek.SUNDAY && pattern.getSunday()) days++;
        }

        if (Boolean.TRUE.equals(pattern.getMorning())) eventsPerDay++;
        if (Boolean.TRUE.equals(pattern.getDay())) eventsPerDay++;
        if (Boolean.TRUE.equals(pattern.getEvening())) eventsPerDay++;

        return eventsPerDay*days;
    }
}
