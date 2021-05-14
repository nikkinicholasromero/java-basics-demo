package com.demo;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    public static void main(String[] args) {
        resourceBundleProperties();
    }

    private static void locales() {
        Locale defaultLocale = Locale.getDefault();

        Locale locale01 = new Locale("en");
        Locale locale02 = new Locale("en", "US");
        Locale locale03 = Locale.ENGLISH;
        Locale locale04 = Locale.US;
        Locale locale05 = new Locale.Builder().setLanguage("en").build();
        Locale locale06 = new Locale.Builder().setLanguage("en").setRegion("US").build();

        Locale.setDefault(locale01);

        Arrays.stream(Locale.getAvailableLocales())
                .map(e -> e.getLanguage() + ":" + e.getCountry())
                .sorted()
                .forEach(System.out::println);
    }

    private static void resourceBundleProperties() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale("fil", "PH"));
        System.out.println(resourceBundle.getString("hello"));
    }
}
