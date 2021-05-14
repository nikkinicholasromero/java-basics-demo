package com.demo;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Formatting {
    public static void main(String[] args) throws ParseException {
        System.out.println(MessageFormat.format("Hello {0}", "Nikki"));

        numberFormat();
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
}
