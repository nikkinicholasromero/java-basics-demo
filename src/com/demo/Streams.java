package com.demo;

import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Nikki", "Leslie", "Maven", "Megan");
        names.sorted(Collections.reverseOrder()).forEach(System.out::println);

        primitiveStreams();
    }

    private static void primitiveStreams() {
        // chart, byte, short, int
        IntStream intStream01 = IntStream.empty();
        IntStream intStream02 = IntStream.of(1, 2, 3);
        IntStream intStream03 = IntStream.generate(() -> 1);
        IntStream intStream04 = IntStream.iterate(1, (a) -> a + 1);
        IntStream intStream05 = IntStream.range(1, 6);
        IntStream intStream06 = IntStream.rangeClosed(1, 5);

        // long
        LongStream longStream01 = LongStream.empty();
        LongStream longStream02 = LongStream.of(1, 2, 3);
        LongStream longStream03 = LongStream.generate(() -> 1);
        LongStream longStream04 = LongStream.iterate(1, (a) -> a + 1);
        LongStream longStream05 = LongStream.range(1, 6);
        LongStream longStream06 = LongStream.rangeClosed(1, 5);

        // double, float
        DoubleStream doubleStream01 = DoubleStream.empty();
        DoubleStream doubleStream02 = DoubleStream.of(1, 2, 3);
        DoubleStream doubleStream03 = DoubleStream.generate(() -> 1);
        DoubleStream doubleStream04 = DoubleStream.iterate(1, (a) -> a + 1);
        // DoubleStream doubleStream05 = DoubleStream.range(1, 6); // DoubleStream does not have range method
        // DoubleStream doubleStream06 = DoubleStream.rangeClosed(1, 5); // DoubleStream does not have rangeClosed method
    }
}
