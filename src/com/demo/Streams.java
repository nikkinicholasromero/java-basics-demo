package com.demo;

import java.util.*;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
//        Stream<String> names = Stream.of("Nikki", "Leslie", "Maven", "Megan");
//        names.sorted(Collections.reverseOrder()).forEach(System.out::println);

        primitiveStreams();
//        convertingStreams();
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

        int intStreamSum = intStream01.sum();
        long longStreamSum = longStream01.sum();
        double doubleStreamSum = doubleStream01.sum();

        OptionalDouble optionalDouble01 = IntStream.of(1, 2, 3).average();
        OptionalDouble optionalDouble02 = LongStream.of(1, 2, 3).average();
        OptionalDouble optionalDouble03 = DoubleStream.of(1, 2, 3).average();

        DoubleSupplier doubleSupplier = Math::random;
        System.out.println(optionalDouble01.orElseGet(doubleSupplier));
        if (optionalDouble01.isPresent()) {
            System.out.println(optionalDouble01.getAsDouble());
        }

        IntSummaryStatistics intSummaryStatistics = IntStream.of(1, 2, 3).summaryStatistics();
        System.out.println(intSummaryStatistics.getCount()); // 3
        System.out.println(intSummaryStatistics.getMin()); // 1
        System.out.println(intSummaryStatistics.getMax()); // 3
        System.out.println(intSummaryStatistics.getSum()); // 6
        System.out.println(intSummaryStatistics.getAverage()); // 2.0
    }

    private static void convertingStreams() {
        Stream<String> streamToStreamSource = Stream.of("Nikki", "Leslie", "Maven", "Megan");
        Function<String, String> streamToStreamMapper = String::toUpperCase;
        Stream<String> streamToStreamOutput = streamToStreamSource.map(streamToStreamMapper);
        streamToStreamOutput.forEach(System.out::println);

        Stream<String> streamToIntSource = Stream.of("Nikki", "Leslie", "Maven", "Megan");
        ToIntFunction<String> streamToIntMapper = String::length;
        IntStream streamToIntOutput = streamToIntSource.mapToInt(streamToIntMapper);
        streamToIntOutput.forEach(System.out::println);

        Stream<String> streamToLongSource = Stream.of("Nikki", "Leslie", "Maven", "Megan");
        ToLongFunction<String> streamToLongMapper = String::length;
        LongStream streamToLongOutput = streamToLongSource.mapToLong(streamToLongMapper);
        streamToLongOutput.forEach(System.out::println);

        Stream<String> streamToDoubleSource = Stream.of("Nikki", "Leslie", "Maven", "Megan");
        ToDoubleFunction<String> streamToDoubleMapper = (s) -> s.length() / 1.5;
        DoubleStream streamToDoubleOutput = streamToDoubleSource.mapToDouble(streamToDoubleMapper);
        streamToDoubleOutput.forEach(System.out::println);

        IntStream intStreamToStreamSource = IntStream.of(1, 2, 3, 4);
        IntFunction<String> intStreamToStreamMapper = String::valueOf;
        Stream<String> intStreamToStreamOutput = intStreamToStreamSource.mapToObj(intStreamToStreamMapper);
        intStreamToStreamOutput.forEach(System.out::println);

        IntStream intStreamToIntStreamSource = IntStream.of(1, 2, 3, 4);
        IntUnaryOperator intStreamToIntStreamMapper = (v) -> v * v;
        IntStream intStreamToIntStreamOutput = intStreamToIntStreamSource.map(intStreamToIntStreamMapper);
        intStreamToIntStreamOutput.forEach(System.out::println);

        IntStream intStreamToLongStreamSource = IntStream.of(1, 2, 3, 4);
        IntToLongFunction intStreamToLongStreamMapper = (v) -> v * v;
        LongStream intStreamToLongStreamOutput = intStreamToLongStreamSource.mapToLong(intStreamToLongStreamMapper);
        intStreamToLongStreamOutput.forEach(System.out::println);

        IntStream intStreamToDoubleStreamSource = IntStream.of(1, 2, 3, 4);
        IntToDoubleFunction intStreamToDoubleStreamMapper = (v) -> v * v;
        DoubleStream intStreamToDoubleStreamOutput = intStreamToDoubleStreamSource.mapToDouble(intStreamToDoubleStreamMapper);
        intStreamToDoubleStreamOutput.forEach(System.out::println);

        LongStream longStreamToStreamSource = LongStream.of(1, 2, 3, 4);
        LongFunction<String> longStreamToStreamMapper = String::valueOf;
        Stream<String> longStreamToStreamOutput = longStreamToStreamSource.mapToObj(longStreamToStreamMapper);
        longStreamToStreamOutput.forEach(System.out::println);

        LongStream longStreamToIntStreamSource = LongStream.of(1, 2, 3, 4);
        LongToIntFunction longStreamToIntStreamMapper = (v) -> (int) v;
        IntStream longStreamToIntStreamOutput = longStreamToIntStreamSource.mapToInt(longStreamToIntStreamMapper);
        longStreamToIntStreamOutput.forEach(System.out::println);

        LongStream longStreamToLongStreamSource = LongStream.of(1, 2, 3, 4);
        LongUnaryOperator longStreamToLongStreamMapper = (v) -> v * v;
        LongStream longStreamToLongStreamOutput = longStreamToLongStreamSource.map(longStreamToLongStreamMapper);
        longStreamToLongStreamOutput.forEach(System.out::println);

        LongStream longStreamToDoubleStreamSource = LongStream.of(1, 2, 3, 4);
        LongToDoubleFunction longStreamToDoubleStreamMapper = (v) -> v / 1.5;
        DoubleStream longStreamToDoubleStreamOutput = longStreamToDoubleStreamSource.mapToDouble(longStreamToDoubleStreamMapper);
        longStreamToDoubleStreamOutput.forEach(System.out::println);

        DoubleStream doubleStreamToStreamSource = DoubleStream.of(1.0, 2.0, 3.0, 4.0);
        DoubleFunction<String> doubleStreamToStreamMapper = String::valueOf;
        Stream<String> doubleStreamToStreamOutput = doubleStreamToStreamSource.mapToObj(doubleStreamToStreamMapper);
        doubleStreamToStreamOutput.forEach(System.out::println);

        DoubleStream doubleStreamToIntStreamSource = DoubleStream.of(1.0, 2.0, 3.0, 4.0);
        DoubleToIntFunction doubleStreamToIntStreamMapper = (v) -> (int) v;
        IntStream doubleStreamToIntStreamOutput = doubleStreamToIntStreamSource.mapToInt(doubleStreamToIntStreamMapper);
        doubleStreamToIntStreamOutput.forEach(System.out::println);

        DoubleStream doubleStreamToLongStreamSource = DoubleStream.of(1.0, 2.0, 3.0, 4.0);
        DoubleToLongFunction doubleStreamToLongStreamMapper = (v) -> (long) v;
        LongStream doubleStreamToLongStreamOutput = doubleStreamToLongStreamSource.mapToLong(doubleStreamToLongStreamMapper);
        doubleStreamToLongStreamOutput.forEach(System.out::println);

        DoubleStream doubleStreamToDoubleStreamSource = DoubleStream.of(1.0, 2.0, 3.0, 4.0);
        DoubleUnaryOperator doubleStreamToDoubleStreamMapper = (v) -> v * v;
        DoubleStream doubleStreamToDoubleStreamOutput = doubleStreamToDoubleStreamSource.map(doubleStreamToDoubleStreamMapper);
        doubleStreamToDoubleStreamOutput.forEach(System.out::println);
    }
}
