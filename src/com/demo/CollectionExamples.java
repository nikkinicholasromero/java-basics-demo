package com.demo;

import java.util.*;

public class CollectionExamples {
    public static void main(String[] args) {
        list(new ArrayList<>());
        list(new LinkedList<>());
        list(new Vector<>());
        list(new Stack<>());
    }

    private static void list(List<String> someList) {
        // add, get, set, contains, indexOf, lastIndexOf, remove, isEmpty, size, clear
        System.out.println(someList.add("World")); // true
        someList.add(0, "Hello"); // true
        // someList.add(3, "Hi"); // throws IndexOutOfBoundsException
        System.out.println(someList); // [Hello, World]

        System.out.println(someList.get(0)); // Hello
        // System.out.println(someList.get(2)); // throws Exception

        System.out.println(someList.set(0, "Kamusta")); // Hello
        System.out.println(someList); // [Kamusta, World]

        // System.out.println(someList.set(2, "Kamusta")); // throws IndexOutOfBoundsException

        System.out.println(someList.contains("Hello")); // false
        System.out.println(someList.contains("Kamusta")); // true

        System.out.println(someList.indexOf("Kamusta")); // 0
        System.out.println(someList.indexOf("Hello")); // -1

        System.out.println(someList.lastIndexOf("Kamusta")); // 0
        System.out.println(someList.lastIndexOf("Hello")); // -1

        System.out.println(someList.remove("World")); // true
        System.out.println(someList.remove("Hello")); // false

        System.out.println(someList.isEmpty()); // false
        System.out.println(someList.size()); // 1
        someList.clear();
        System.out.println(someList); // []
    }
}
