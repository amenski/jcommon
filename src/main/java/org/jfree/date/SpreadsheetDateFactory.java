package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SpreadsheetDateFactory extends SerialDateFactory {

    @Override
    public SerialDate createInstanceInternal(int serial) {
        return new SpreadsheetDate(serial);
    }

    @Override
    public SerialDate createInstanceInternal(Date date, Calendar type) {
        if (type instanceof GregorianCalendar) {
            final GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            return new SpreadsheetDate(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        }
        return null;
    }

    @Override
    protected SerialDate createInstanceInternal(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }
}
