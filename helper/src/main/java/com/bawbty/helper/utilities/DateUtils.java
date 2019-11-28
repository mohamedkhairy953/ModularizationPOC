package com.bawbty.helper.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    /**
     * Compare to dates and check if they are in the same day or not
     */
    public static boolean isInTheSameDate(Date firstDate, Date secondDate) {
        Calendar firstDateCalendar = Calendar.getInstance();
        Calendar secondDateCalendar = Calendar.getInstance();
        firstDateCalendar.setTime(firstDate);
        secondDateCalendar.setTime(secondDate);
        return firstDateCalendar.get(Calendar.DAY_OF_YEAR) == secondDateCalendar.get(Calendar.DAY_OF_YEAR) &&
                firstDateCalendar.get(Calendar.YEAR) == secondDateCalendar.get(Calendar.YEAR);
    }

    /**
     * Convert UTC date to device local timezone
     */
    public static Date dateToLocalDate(Date date) {
        Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String timeZone = utcCalendar.getInstance().getTimeZone().getID();
        return new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
    }

    public static String getTimeAgo(Date date) {
        long time = date.getTime();
        long now = System.currentTimeMillis();
        CharSequence ago =
                android.text.format.DateUtils.getRelativeTimeSpanString(time, now, android.text.format.DateUtils.MINUTE_IN_MILLIS);
        return ago.toString();
    }

    public static boolean isDateIsBiggerThanCurrentDate(long timeInMillis) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        return timeInMillis > currentTime;
    }
}
