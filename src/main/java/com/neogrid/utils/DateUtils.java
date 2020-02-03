package com.neogrid.utils;


import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    public static Calendar createNewDateWithHourMinuteAndSecond(int hour, int minute, int second) {
        Calendar newDate = new GregorianCalendar();
        newDate.set(Calendar.HOUR, hour);
        newDate.set(Calendar.MINUTE, minute);
        newDate.set(Calendar.SECOND, second);

        return newDate;
    }

    public static String convertCalendarToFormatedString(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        return simpleDateFormat.format(calendar.getTime());
    }

    public static void sumMinutesInACreatedCalendar(int minutesToAdd, Calendar calendarToAdd) {
        calendarToAdd.add(Calendar.MINUTE, minutesToAdd);
    }

}