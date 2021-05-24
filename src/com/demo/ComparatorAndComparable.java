package com.demo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorAndComparable {
    public static void main(String[] args) {
        Comparator<Duck> comparator = Comparator
                .comparing(Duck::getName)
                .thenComparing(Duck::getWeight);

        Set<Rabbit> rabbitSet = new TreeSet<>();
        rabbitSet.add(new Rabbit("", 0.0));

        Set<Fish> fishSet = new TreeSet<>();
        fishSet.add(new Fish("", 0.0));

        Set<Duck> duckSet = new TreeSet<>(comparator);
        duckSet.add(new Duck("", 0.0));

        // Set<Duck> duckSet1 = new TreeSet<>();
        // duckSet1.add(new Duck("", 0.0)); // throws ClassCastException
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

    public Duck(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

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

class Fish implements Comparable {
    private String name;
    private double weight;

    public Fish(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Rabbit implements Comparable<Rabbit> {
    private String name;
    private double weight;

    public Rabbit(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

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

    @Override
    public int compareTo(Rabbit o) {
        return 0;
    }
}
