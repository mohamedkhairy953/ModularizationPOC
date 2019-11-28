package com.bawbty.helper.utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ElapsedTime is an utility to generate strings that describe an elapsed time.
 * Examples:
 * - Moments ago
 * - 2 days ago
 * - 3 hours, 32 minutes and 8 seconds ago
 * - 2 months ago
 *
 * @author Vincent DURMONT [vdurmont@gmail.com]
 */
public class ElapsedTime {
    /**
     * The locale to use if no locale is provided when calling the method
     */
    public static Locale defaultLocale = Locale.ENGLISH;

    /**
     * The smallest time division that can be printed. Everything below will be considered as "moments ago".
     */
    public static TimeDivision smallestTimeDivision = TimeDivision.SECOND;


    /**
     * Private constructor. No instance needed.
     */
    private ElapsedTime() {
    }

    /**
     * Returns the string representing the duration between the provided date and the present instant.
     *
     * @param date the date (in the past)
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the date is in the future
     */
    public static String getFromDate(Date date) {
        return getFromDate(date, defaultLocale);
    }

    /**
     * Returns the string representing the duration between the provided date and the present instant.
     *
     * @param date   the date (in the past)
     * @param locale the locale to use for this string
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the date is in the future
     */
    public static String getFromDate(Date date, Locale locale) {
        if (date == null) return "";
        Date now = new Date();
        long durationMillis = now.getTime() - date.getTime();
        return getFromDurationMillis(durationMillis, locale);
    }

    /**
     * Returns the string representing the provided duration.
     *
     * @param durationSeconds the duration to represent in seconds
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the duration is lower than 0
     */
    public static String getFromDurationSeconds(long durationSeconds) {
        return getFromDurationMillis(durationSeconds * 1000);
    }

    /**
     * Returns the string representing the provided duration.
     *
     * @param durationSeconds the duration to represent in seconds
     * @param locale          the locale to use for this string
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the duration is lower than 0
     * @throws IllegalArgumentException if the locale is null
     */
    public static String getFromDurationSeconds(long durationSeconds, Locale locale) {
        return getFromDurationMillis(durationSeconds * 1000, locale);
    }

    /**
     * Returns the string representing the provided duration.
     *
     * @param durationMillis the duration to represent in milliseconds
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the duration is lower than 0
     */
    public static String getFromDurationMillis(long durationMillis) {
        return getFromDurationMillis(durationMillis, defaultLocale);
    }

    /**
     * Returns the string representing the provided duration.
     *
     * @param durationMillis the duration to represent in milliseconds
     * @param locale         the locale to use for this string
     * @return the string representing the provided duration
     * @throws IllegalArgumentException if the duration is lower than 0
     * @throws IllegalArgumentException if the locale is null
     */
    public static String getFromDurationMillis(long durationMillis, Locale locale) {
        if (durationMillis < 0) {
            throw new IllegalArgumentException("The provided duration is < 0.");
        }
        if (locale == null) {
            throw new IllegalArgumentException("The provided locale is null.");
        }
        Map<TimeDivision, Long> dividedTime = divideTime(durationMillis);
        TimeDivision division = TimeDivision.YEAR;
        long value = 0;
        while (division != null && value == 0 && dividedTime != null) {
            value = dividedTime.get(division);
            if (value == 0) {
                division = division.getSubDivision();
            }
        }

        if (division == null) {
            throw new RuntimeException("Unable to divide the time properly.");
        }

        // Check if we crossed the current division threshold
        boolean crossed = false;
        if (division.getSuperDivision() != null && value >= division.getThreshold()) {
            division = division.getSuperDivision();
            value = 1;
            crossed = true;
        }


        // Check if we crossed a threshold in the subdivision
        // We don't do it if we already increased the division, it can't happen
        TimeDivision subDivision = division.getSubDivision();
        if (!crossed && subDivision != null) {
            long remaining = durationMillis % division.getMillis();
            if (remaining >= subDivision.getThresholdMillis()) {
                value++;
            }
        }

        // If our time division cannot be printed, return the "epsilon" text.
        if (smallestTimeDivision.getMillis() > division.getMillis()) {
            return locale.getString(StringKey.MOMENTS_AGO);
        }

        // Else return the singular or plural text
        if (value > 1) {
            String s = "";
            try {
                s = locale.getString(division.getPluralStringKey()).replaceAll("\\{num\\}", String.valueOf(value));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return s;
        }
        return locale.getString(division.getSingularStringKey());
    }

    /**
     * Creates a hashmap with the amount of each division that can be fit into the duration.
     * We start at the biggest division and everytime a division can fit, we decrease the remaining duration.
     * <p>
     * Example:
     * - 275723300 millis can fit: 3 days + 4 hours + 35 minutes + 23 seconds + 300 millis
     *
     * @param duration the duration to divide
     * @return the amount for each {@link TimeDivision}
     */
    private static Map<TimeDivision, Long> divideTime(long duration) {
        TimeDivision division = TimeDivision.YEAR;
        Map<TimeDivision, Long> results = new HashMap<>();

        while (division != null) {
            results.put(division, duration / division.getMillis());
            duration %= division.getMillis();
            division = division.getSubDivision();
        }

        return results;
    }


    /**
     * Represents the different time divisions supported by this library.
     * Also provides useful information such as:
     * - the duration of this division in millis,
     * - the string keys for plural and singular forms
     * - the subdivision
     * - a threshold that, once reach, will increase the super division amount by 1
     */
    private static enum TimeDivision {
        MILLIS(1, StringKey.MILLISECOND_AGO, StringKey.MILLISECONDS_AGO, 750),
        SECOND(1000, StringKey.SECOND_AGO, StringKey.SECONDS_AGO, 45),
        MINUTE(60 * TimeDivision.SECOND.getMillis(), StringKey.MINUTE_AGO, StringKey.MINUTES_AGO, 45),
        HOUR(60 * TimeDivision.MINUTE.getMillis(), StringKey.HOUR_AGO, StringKey.HOURS_AGO, 22),
        DAY(24 * TimeDivision.HOUR.getMillis(), StringKey.DAY_AGO, StringKey.DAYS_AGO, 26),
        MONTH(30 * TimeDivision.DAY.getMillis(), StringKey.MONTH_AGO, StringKey.MONTHS_AGO, 11), // Duration is an approximation
        YEAR(12 * TimeDivision.MONTH.getMillis(), StringKey.YEAR_AGO, StringKey.YEARS_AGO, 0); // Duration is an approximation

        /**
         *  Workaround to avoid IllegalForwardReferences
         */
        static {
            // Setting the subDivisions
            SECOND.subDivision = MILLIS;
            MINUTE.subDivision = SECOND;
            HOUR.subDivision = MINUTE;
            DAY.subDivision = HOUR;
            MONTH.subDivision = DAY;
            YEAR.subDivision = MONTH;

            // Setting the superDivisions
            MILLIS.superDivision = SECOND;
            SECOND.superDivision = MINUTE;
            MINUTE.superDivision = HOUR;
            HOUR.superDivision = DAY;
            DAY.superDivision = MONTH;
            MONTH.superDivision = YEAR;
        }

        private final long millis;
        private final StringKey singularStringKey;
        private final StringKey pluralStringKey;
        private TimeDivision subDivision;
        private TimeDivision superDivision;
        private final long threshold;

        TimeDivision(long millis, StringKey singularStringKey, StringKey pluralStringKey, long threshold) {
            this.millis = millis;
            this.singularStringKey = singularStringKey;
            this.pluralStringKey = pluralStringKey;
            this.threshold = threshold;
        }

        public long getMillis() {
            return millis;
        }

        public StringKey getSingularStringKey() {
            return singularStringKey;
        }

        public StringKey getPluralStringKey() {
            return pluralStringKey;
        }

        public TimeDivision getSubDivision() {
            return subDivision;
        }

        public TimeDivision getSuperDivision() {
            return superDivision;
        }

        public long getThreshold() {
            return threshold;
        }

        public long getThresholdMillis() {
            return threshold * millis;
        }
    }

    /**
     * The supported languages and their associated strings.
     */
    public enum Locale {
        ENGLISH(StringsMap.newInstance()
                .with(StringKey.MOMENTS_AGO, "Moments ago")
                .with(StringKey.MILLISECOND_AGO, "1 " + "millisecond ago")
                .with(StringKey.MILLISECONDS_AGO, "{num} " + "milliseconds ago")
                .with(StringKey.SECOND_AGO, "1 " + "second ago")
                .with(StringKey.SECONDS_AGO, "{num} " + "seconds ago")
                .with(StringKey.MINUTE_AGO, "1 " + "minute ago")
                .with(StringKey.MINUTES_AGO, "{num} " + "minutes ago")
                .with(StringKey.HOUR_AGO, "1 " + "hour ago")
                .with(StringKey.HOURS_AGO, "{num} " + "hours ago")
                .with(StringKey.DAY_AGO, "1 " + "day ago")
                .with(StringKey.DAYS_AGO, "{num} " + "days ago")
                .with(StringKey.MONTH_AGO, "1 " + "month ago")
                .with(StringKey.MONTHS_AGO, "{num} " + "months ago")
                .with(StringKey.YEAR_AGO, "1 " + "year ago")
                .with(StringKey.YEARS_AGO, "{num}" + "years ago"));


        private Map<StringKey, String> strings;

        Locale(Map<StringKey, String> strings) {
            this.strings = strings;
        }

        public String getString(StringKey key) {
            return this.strings.get(key);
        }
    }

    /**
     * The keys for the strings used in the generation
     */
    protected enum StringKey {
        MOMENTS_AGO,
        MILLISECOND_AGO, MILLISECONDS_AGO,
        SECOND_AGO, SECONDS_AGO,
        MINUTE_AGO, MINUTES_AGO,
        HOUR_AGO, HOURS_AGO,
        DAY_AGO, DAYS_AGO,
        MONTH_AGO, MONTHS_AGO,
        YEAR_AGO, YEARS_AGO
    }

    /**
     * A utility class to create a HashMap<StringKey, String> with a fluent syntax.
     */
    private static class StringsMap extends HashMap<StringKey, String> {
        public static StringsMap newInstance() {
            return new StringsMap();
        }

        public StringsMap with(StringKey key, String value) {
            this.put(key, value);
            return this;
        }
    }
}
