package com.neogrid.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtilsTest {

    @Test
    public void testNewCalendarSettingHourToNineMinuteToZeroAndSecondToZero() {
        Calendar currentDate = DateUtils.createNewDateWithHourMinuteAndSecond(-3, 0, 0);

        Assert.assertEquals(9, currentDate.get(Calendar.HOUR));
        Assert.assertEquals(0, currentDate.get(Calendar.MINUTE));
        Assert.assertEquals(0, currentDate.get(Calendar.SECOND));
    }

    @Test
    public void testConvertCalendarToString() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        String currentDateFormated = DateUtils.convertCalendarToFormatedString(calendar);

        Assert.assertEquals("12:00", currentDateFormated);
    }

    @Test
    public void testSumMinutesInACalendar() {
        Calendar calendar = DateUtils.createNewDateWithHourMinuteAndSecond(0, 0, 0 );
        DateUtils.sumMinutesInACreatedCalendar(30, calendar);

        String currentDateFormated = DateUtils.convertCalendarToFormatedString(calendar);

        Assert.assertEquals("12:30", currentDateFormated);
    }

}


