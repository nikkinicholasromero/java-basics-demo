package com.demo;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
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
        System.out.println(Locale.getDefault());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale("fil", "PH"));
//        System.out.println(resourceBundle.getString("hello"));
//        System.out.println(resourceBundle.getString("hi"));
//        System.out.println(resourceBundle.getString("goodbye"));

        Properties properties = new Properties();

        resourceBundle.keySet()
                .stream()
                .peek(e -> properties.put(e, resourceBundle.getString(e)))
                .map(e -> e + ":" + resourceBundle.getString(e))
                .forEach(System.out::println);

        System.out.println(properties.getProperty("hello"));
        System.out.println(properties.getProperty("hello", "Hello"));
        System.out.println(properties.getOrDefault("hello", "Hello"));
    }
}
