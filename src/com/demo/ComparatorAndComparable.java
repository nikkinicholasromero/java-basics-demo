package com.demo;

import java.util.Comparator;

public class ComparatorAndComparable {
    public static void main(String[] args) {
        Comparator<Duck> comparator = Comparator
                .comparing(Duck::getName)
                .thenComparing(Duck::getWeight);
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
    private String name;
    private double weight;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
