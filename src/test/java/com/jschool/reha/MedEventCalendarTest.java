package com.jschool.reha;

import com.jschool.reha.entity.Pattern;
import com.jschool.reha.service.helpers.MedEventCalendarImpl;
import org.junit.Assert;
import org.junit.Test;

public class MedEventCalendarTest {

    @Test
    public void test1(){
        MedEventCalendarImpl medEventCalendar=new MedEventCalendarImpl();

        Pattern pattern=new Pattern();
        pattern.setMorning(false);
        pattern.setDay(true);
        pattern.setEvening(false);

        int hour=0;

        Assert.assertEquals( 13,medEventCalendar.findNextPossibleHour(hour,pattern));

    }
}
