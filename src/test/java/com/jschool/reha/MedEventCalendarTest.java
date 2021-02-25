package com.jschool.reha;

import com.jschool.reha.entity.Pattern;
import com.jschool.reha.service.helpers.MedEventCalendarImpl;
import org.junit.Assert;
import org.junit.Test;

public class MedEventCalendarTest {
    MedEventCalendarImpl medEventCalendar=new MedEventCalendarImpl();

    @Test
    public void calendarTest1(){


        Pattern pattern=new Pattern();
        pattern.setMorning(false);
        pattern.setDay(true);
        pattern.setEvening(false);

        int hour=0;

        Assert.assertEquals( 13,medEventCalendar.findNextPossibleHour(hour,pattern));
    }

    @Test (expected = NullPointerException.class)
    public void calendarTest2() {

        Pattern pattern=null;
        int hour=0;

        medEventCalendar.findNextPossibleHour(hour,pattern);
    }

    @Test (expected = NullPointerException.class)
    public void calendarTest3() {
        Pattern pattern=new Pattern();
        int hour=0;

        medEventCalendar.findNextPossibleHour(hour,pattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calendarTest4(){

        Pattern pattern=new Pattern();
        pattern.setMorning(false);
        pattern.setDay(true);
        pattern.setEvening(false);

        int hour=30;

        medEventCalendar.findNextPossibleHour(hour,pattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calendarTest5(){

        Pattern pattern=new Pattern();
        pattern.setMorning(false);
        pattern.setDay(true);
        pattern.setEvening(false);

        int hour=Integer.MAX_VALUE;

        medEventCalendar.findNextPossibleHour(hour,pattern);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calendarTest6(){

        Pattern pattern=new Pattern();
        pattern.setMorning(false);
        pattern.setDay(true);
        pattern.setEvening(false);

        int hour=Integer.MAX_VALUE;

        medEventCalendar.findNextPossibleHour(hour,pattern);
    }

    @Test
    public void calendarTest7(){

        Pattern pattern=new Pattern();
        pattern.setMorning(true);
        pattern.setDay(true);
        pattern.setEvening(true);

        int hour=14;

        Assert.assertEquals( 17,medEventCalendar.findNextPossibleHour(hour,pattern));
    }

    @Test
    public void calendarTest8(){

        Pattern pattern=new Pattern();
        pattern.setMorning(true);
        pattern.setDay(false);
        pattern.setEvening(true);

        int hour=10;

        Assert.assertEquals( 17,medEventCalendar.findNextPossibleHour(hour,pattern));
    }

    @Test
    public void calendarTest9(){

        Pattern pattern=new Pattern();
        pattern.setMorning(true);
        pattern.setDay(false);
        pattern.setEvening(false);

        int hour=10;

        Assert.assertEquals( 0,medEventCalendar.findNextPossibleHour(hour,pattern));
    }

    @Test
    public void calendarTest10(){

        Pattern pattern=new Pattern();
        pattern.setMorning(true);
        pattern.setDay(false);
        pattern.setEvening(false);

        int hour=0;

        Assert.assertEquals( 9,medEventCalendar.findNextPossibleHour(hour,pattern));
    }
}
