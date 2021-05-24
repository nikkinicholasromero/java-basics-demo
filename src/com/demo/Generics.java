package com.demo;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
    }

    private static void mixingRaws() {
        Number number = 1.1;
        List<Number> numbers01 = new ArrayList<Number>();
        // List<Number> numbers02 = new ArrayList<Integer>(); // doesn't compile
        List<Number> numbers03 = new ArrayList<>();
        List<Number> numbers04 = new ArrayList();

        // List<> numbers05 = new ArrayList(); // doesn't compile
        List numbers05 = new ArrayList<Number>();
        List numbers06 = new ArrayList<>();
        List numbers07 = new ArrayList();
    }
}

interface SomeInterface<T> {

}

class SomeClass<T> implements SomeInterface<T> {

}

class SomeSubClass extends SomeClass<Integer> {

}

