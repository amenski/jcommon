package org.jfree.date;

import java.text.DateFormatSymbols;

public enum Month {
    JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6), JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
    private final int monthNumber;

    Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int get() {
        return monthNumber;
    }

    public static Month from(int monthNumber) {
        for (Month m : Month.values()) {
            if (monthNumber == m.monthNumber) return m;
        }
        throw new IllegalArgumentException("MonthConstants: Invalid value for month");
    }


    private static final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

    public static Month parse(String s) {
        s = s.trim();
        for (Month m : Month.values()) {
            if (m.matches(s)) return m;
        }
        throw new IllegalArgumentException(String.format("Month.parse(): %s is not a valid month string", s));
    }

    public int quarter() {
        return 1 + (monthNumber - 1) / 3;
    }

    public String toShortString() {
        return dateFormatSymbols.getShortMonths()[monthNumber - 1];
    }

    @Override
    public String toString() {
        return dateFormatSymbols.getMonths()[monthNumber - 1];
    }

    private boolean matches(String s) {
        return s.equalsIgnoreCase(toString())
                || s.equalsIgnoreCase(toShortString());
    }
}
