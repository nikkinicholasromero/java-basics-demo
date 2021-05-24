package com.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapApi {
    public static void main(String[] args) {
        computeIfAbsent();
    }

    private static void putIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("Jenny", "Bus Tour");
        map.put("Sam", null);

        System.out.println(map); // {Jenny=Bus Tour, Sam=null}

        map.putIfAbsent("Jenny", "Tram");
        map.putIfAbsent("Sam", "Tram");
        map.putIfAbsent("Tom", "Tram");

        System.out.println(map); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
    }

    public static void merge() {
        BiFunction<String, String, String> mapper = (a, b) -> {
            if (a.length() > b.length()) {
                return a;
            } else if (b.length() > a.length()) {
                return b;
            } else {
                return null;
            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("A", "AB");
        map.put("B", "ABCD");
        map.put("C", null);
        map.put("E", "ABC");

        System.out.println(map); // {A=AB, B=ABCD, C=null, E=ABC}

        map.merge("A", "ABC", mapper); // ABC
        map.merge("B", "ABC", mapper); // ABCD
        map.merge("C", "ABC", mapper); // ABC
        map.merge("D", "ABC", mapper); // ABC
        map.merge("E", "ABC", mapper); // null

        System.out.println(map); // {A=ABC, B=ABCD, C=ABC, D=ABC}
    }

    private static void computeIfPresent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Sam", 0);
        counts.put("Marie", null);

        // BiFunction<String, Integer, String> mapper = (k, v) -> "Length is " + v;
        // Integer jenny = counts.computeIfPresent("Jenny", mapper); // does not compile

        BiFunction<String, Integer, Integer> mapper = (k, v) -> v != 0 ? v + 1 : null;
        Integer jenny = counts.computeIfPresent("Jenny", mapper); // 2
        Integer sam = counts.computeIfPresent("Sam", mapper); // null
        Integer tom = counts.computeIfPresent("Tom", mapper); // null
        Integer marie = counts.computeIfPresent("Marie", mapper); // null

        System.out.println(counts); // {Jenny=2}
        System.out.println(jenny); // 2
        System.out.println(sam); // null
        System.out.println(tom); // null
        System.out.println(marie); // null
    }

    private static void computeIfAbsent() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        counts.put("Marie", null);

        Function<String, Integer> mapper = (k) -> k.equals("Sam") ? null : k.length();
        Integer jenny = counts.computeIfAbsent("Jenny", mapper); // 1
        Integer sam = counts.computeIfAbsent("Sam", mapper); // null
        Integer tom = counts.computeIfAbsent("Tom", mapper); // 3
        Integer marie = counts.computeIfAbsent("Marie", mapper); // 5

        System.out.println(counts); // {Marie=5, Tom=3, Jenny=1}
        System.out.println(jenny); // 1
        System.out.println(sam); // null
        System.out.println(tom); // 3
        System.out.println(marie); // 5
    }
}
