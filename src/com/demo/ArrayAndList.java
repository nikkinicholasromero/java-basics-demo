package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndList {
    public static void main(String[] args) {

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
    }
}
