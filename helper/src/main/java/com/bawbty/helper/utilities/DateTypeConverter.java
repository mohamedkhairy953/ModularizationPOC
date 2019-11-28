package com.bawbty.helper.utilities;

import java.util.Date;

import androidx.room.TypeConverter;

/**
 * Created by Mohamed Khaled on Thu, 01/Nov/2018 at 1:11 PM.
 * <p>
 * mohamed.khaled@apptcom.com
 * linkedin.com/in/mohamed5aled
 */
public class DateTypeConverter {
    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}
