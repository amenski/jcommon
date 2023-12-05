package org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class SerialDateFactory {
    private static SerialDateFactory factory = new SpreadsheetDateFactory();

    protected abstract SerialDate createInstanceInternal(int serial);
    protected abstract SerialDate createInstanceInternal(Date date, Calendar type);
    protected abstract SerialDate createInstanceInternal(int day, int month, int year);

    public void setFactory(SerialDateFactory newFactory) {
        factory = newFactory;
    }

    public static SerialDate createInstance(int serial) {
        return factory.createInstanceInternal(serial);
    }

    public static SerialDate createInstance(Date date) {
        return createInstance(date, new GregorianCalendar());
    }

    public static SerialDate createInstance(Date date, Calendar type) {
        return factory.createInstanceInternal(date, type);
    }

    public static SerialDate createInstance(int day, int month, int year) {
        return factory.createInstanceInternal(day, month, year);
    }
}
