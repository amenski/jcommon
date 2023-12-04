package org.jfree.date;

import java.text.DateFormatSymbols;

public enum Day {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
    private final int dayNumber;

    Day(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int get() {
        return dayNumber;
    }

    public static Day from(int dayNumber) {
        for (Day d : Day.values()) {
            if (dayNumber == d.dayNumber) return d;
        }
        throw new IllegalArgumentException(String.format("DayOfWeekConstants: Invalid value for day-of-week %s", dayNumber));
    }

    private static final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
    public static Day parse(String s) {
        s = s.trim();
        for (Day d : Day.values()) {
            if (d.matches(s)) {
                return d;
            }
        }
        throw new IllegalArgumentException(String.format("Day.parse(): %s is not a valid day string", s));
    }

    @Override
    public String toString() {
        return dateFormatSymbols.getWeekdays()[dayNumber];
    }

    public String toShortString() {
        return dateFormatSymbols.getShortWeekdays()[dayNumber];
    }

    private boolean matches(String s) {
        return s.equalsIgnoreCase(toString())
                || s.equalsIgnoreCase(toShortString());
    }
}