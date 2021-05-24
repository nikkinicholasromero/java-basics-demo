package com.demo;

import java.util.Comparator;

public class ComparatorAndComparable {
    public static void main(String[] args) {
    }

    private static void packageAndSignature() {
        java.lang.Comparable<Duck> duckComparable = new Comparable<Duck>() {
            @Override
            public int compareTo(Duck o) {
                return 0;
            }
        };
        java.util.Comparator<Duck> duckComparator = new Comparator<Duck>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                return 0;
            }
        };
    }
}

class Duck {

}
