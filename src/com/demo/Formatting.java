package com.demo;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) throws ParseException {
        System.out.println(MessageFormat.format("Hello {0}", "Nikki"));

        numberFormat();
        dateTimeFormatter();
    }

    private static void numberFormat() throws ParseException {
        NumberFormat numberFormat01 = NumberFormat.getInstance();
        NumberFormat numberFormat02 = NumberFormat.getInstance(Locale.getDefault());
        NumberFormat numberFormat03 = NumberFormat.getNumberInstance();
        NumberFormat numberFormat04 = NumberFormat.getNumberInstance(Locale.getDefault());

        NumberFormat numberFormat05 = NumberFormat.getCurrencyInstance();
        NumberFormat numberFormat06 = NumberFormat.getCurrencyInstance(Locale.getDefault());

        NumberFormat numberFormat07 = NumberFormat.getPercentInstance();
        NumberFormat numberFormat08 = NumberFormat.getPercentInstance(Locale.getDefault());

        System.out.println(numberFormat01.format(1_000_000L));
        System.out.println(numberFormat02.format(1_000_000L));
        System.out.println(numberFormat03.format(1_000_000L));
        System.out.println(numberFormat04.format(1_000_000L));

        System.out.println(numberFormat05.format(1_000_000L));
        System.out.println(numberFormat06.format(1_000_000L));

        System.out.println(numberFormat07.format(.95));
        System.out.println(numberFormat08.format(.95));

        System.out.println(numberFormat01.parse("123,456"));
        System.out.println(numberFormat02.parse("123,456"));
        System.out.println(numberFormat03.parse("123,456.50"));
        System.out.println(numberFormat04.parse("123,456.25"));

        System.out.println(numberFormat05.parse("$123,456.50"));
        System.out.println(numberFormat06.parse("$123,456.25"));

        System.out.println(numberFormat07.parse("95%"));
        System.out.println(numberFormat08.parse("95.75%"));
    }

    private static void dateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter01 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter02 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        DateTimeFormatter dateTimeFormatter03 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter04 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

        DateTimeFormatter dateTimeFormatter05 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter06 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println(LocalDateTime.now().format(dateTimeFormatter01)); // 5/14/21
        System.out.println(LocalDateTime.now().format(dateTimeFormatter02)); // May 14, 2021
        System.out.println(LocalDateTime.now().format(dateTimeFormatter03)); // 10:07 AM
        System.out.println(LocalDateTime.now().format(dateTimeFormatter04)); // 10:07:42 AM
        System.out.println(LocalDateTime.now().format(dateTimeFormatter05)); // 5/14/21, 10:07 AM
        System.out.println(LocalDateTime.now().format(dateTimeFormatter06)); // May 14, 2021, 10:07:42 AM

        System.out.println(LocalDate.now().format(dateTimeFormatter01)); // 5/14/21
        System.out.println(LocalDate.now().format(dateTimeFormatter02)); // May 14, 2021
        // System.out.println(LocalDate.now().format(dateTimeFormatter03)); // UnsupportedTemporalTypeException
        // System.out.println(LocalDate.now().format(dateTimeFormatter04)); // UnsupportedTemporalTypeException
        // System.out.println(LocalDate.now().format(dateTimeFormatter05)); // UnsupportedTemporalTypeException
        // System.out.println(LocalDate.now().format(dateTimeFormatter06)); // UnsupportedTemporalTypeException

        DateTimeFormatter dateTimeFormatter07 = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter dateTimeFormatter08 = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dateTimeFormatter09 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dateTimeFormatter10 = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter dateTimeFormatter11 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dateTimeFormatter12 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter13 = DateTimeFormatter.BASIC_ISO_DATE;

        System.out.println("==========");

        System.out.println(dateTimeFormatter07.format(LocalTime.now()));
        System.out.println(dateTimeFormatter08.format(LocalDate.now()));
        System.out.println(dateTimeFormatter09.format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter10.format(LocalTime.now()));
        System.out.println(dateTimeFormatter11.format(LocalDate.now()));
        System.out.println(dateTimeFormatter12.format(LocalDateTime.now()));

        System.out.println(dateTimeFormatter13.format(LocalDateTime.now()));
        System.out.println(dateTimeFormatter13.format(LocalDate.now()));
        // System.out.println(dateTimeFormatter13.format(LocalTime.now())); // UnsupportedTemporalTypeException

        DateTimeFormatter dateTimeFormatter14 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.parse("2020-01-02 12:14:11", dateTimeFormatter14));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter14));
        // System.out.println(LocalDate.now().format(dateTimeFormatter14)); // UnsupportedTemporalTypeException
        // System.out.println(LocalTime.now().format(dateTimeFormatter14)); // UnsupportedTemporalTypeException

        DateTimeFormatter dateTimeFormatter15 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(LocalDate.parse("2020-01-01", dateTimeFormatter15));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter15));
        System.out.println(LocalDate.now().format(dateTimeFormatter15));
        // System.out.println(LocalTime.now().format(dateTimeFormatter15)); // UnsupportedTemporalTypeException

        DateTimeFormatter dateTimeFormatter16 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(LocalTime.parse("12:14:11", dateTimeFormatter16));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter16));
        // System.out.println(LocalDate.now().format(dateTimeFormatter16)); // UnsupportedTemporalTypeException
        System.out.println(LocalTime.now().format(dateTimeFormatter16));
    }
}
