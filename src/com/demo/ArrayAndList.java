package com.demo;

import java.util.*;

public class ArrayAndList {
    public static void main(String[] args) {
        sortingAndSearching();
    }

    private static void arrayToList() {
        String[] namesArray = { "Nikki", "Leslie", "Maven", "Megan" };
        List<String> namesList = Arrays.asList(namesArray);
    }

    private static void listToArray() {
        List<String> namesList = new ArrayList<>();
        namesList.add("Nikki");
        namesList.add("Leslie");
        namesList.add("Maven");
        namesList.add("Megan");

        String[] namesArray0 = namesList.toArray(new String[0]);
        String[] namesArray1 = (String[]) namesList.toArray();

        // java.util.Collection; <-- Interface
        // java.util.Collections; <-- Class
    }

    private static void sortingAndSearching() {
        String[] namesArray = { "Nikki", "Leslie", "Maven", "Megan" };
        Arrays.sort(namesArray);
        System.out.println(Arrays.binarySearch(namesArray, "Maven"));

        List<String> namesList = new ArrayList<>();
        namesList.add("Nikki");
        namesList.add("Leslie");
        namesList.add("Maven");
        namesList.add("Megan");
        Collections.sort(namesList);
        System.out.println(Collections.binarySearch(namesList, "Megan"));
    }
}
