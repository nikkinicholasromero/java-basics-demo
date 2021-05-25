package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        unbounded();
        upperBounded();
        lowerBounded();
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

    // immutable
    private static void unbounded() {
        // List<B> someList = new ArrayList<C>(); // does not compile

        List<?> someList1 = new ArrayList<A>();
        List<?> someList2 = new ArrayList<B>();
        List<?> someList3 = new ArrayList<C>();

        // someList.add(new A()); // does not compile
        // someList.add(new B()); // does not compile
        // someList.add(new C()); // does not compile

        someList1 = Arrays.asList(new A(), new B(), new C());
        A value11 = (A) someList1.get(0);
        B value12 = (B) someList1.get(1);
        C value13 = (C) someList1.get(2);

        someList2 = Arrays.asList(new B(), new C());
        B value21 = (B) someList2.get(0);
        C value22 = (C) someList2.get(1);

        someList3 = Arrays.asList(new C());
        C value31 = (C) someList3.get(0);
    }

    // immutable
    private static void upperBounded() {
        // List<B> someList = new ArrayList<C>(); // does not compile

        // List<? extends B> someList1 = new ArrayList<A>(); // does not compile
        List<? extends B> someList2 = new ArrayList<B>();
        List<? extends B> someList3 = new ArrayList<C>();

        // someList2.add(new A()); // does not compile
        // someList2.add(new B()); // does not compile
        // someList2.add(new C()); // does not compile

        // someList3.add(new A()); // does not compile
        // someList3.add(new B()); // does not compile
        // someList3.add(new C()); // does not compile

        someList2 = Arrays.asList(new B(), new C());
        B value21 = (B) someList2.get(0);
        C value22 = (C) someList2.get(1);

        someList3 = Arrays.asList(new C());
        C value31 = (C) someList3.get(0);
    }

    private static void lowerBounded() {
        // List<B> someList = new ArrayList<A>(); // does not compile

        List<? super B> someList1 = new ArrayList<A>();
        List<? super B> someList2 = new ArrayList<B>();
        // List<? super B> someList3 = new ArrayList<C>(); // does not compile

        // someList1.add(new A()); // does not compile
        someList1.add(new B());
        someList1.add(new C());

        // someList2.add(new A()); // does not compile
        someList2.add(new B());
        someList2.add(new C());

        someList1 = Arrays.asList(new A(), new B(), new C());
        A value11 = (A) someList1.get(0);
        B value12 = (B) someList1.get(1);
        C value13 = (C) someList1.get(2);

        someList2 = Arrays.asList(new B(), new C());
        B value21 = (B) someList2.get(0);
        C value22 = (C) someList2.get(1);
    }
}

class A {

}

class B extends A {

}

class C extends B {

}

interface SomeInterface<T> {

}

class SomeClass<T> implements SomeInterface<T> {

}

class SomeSubClass extends SomeClass<Integer> {

}

