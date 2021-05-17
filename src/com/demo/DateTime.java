package com.demo;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {
        Period p = Period.between(LocalDate.now(), LocalDate.of(2021, Month.MAY, 14));
        System.out.println(p);

        ZoneId zoneId = ZoneId.of("Asia/Singapore");

        ZonedDateTime zonedDateTime00 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime01 = LocalDateTime.now().atZone(zoneId);
        ZonedDateTime zonedDateTime02 = zonedDateTime00.withZoneSameInstant(zoneId);

        System.out.println(zonedDateTime00);
        System.out.println(zonedDateTime01.getDayOfMonth());
        System.out.println(zonedDateTime02.getDayOfMonth());
    }

    private static void instantiation() {
        LocalDate localDate01 = LocalDate.now();
        LocalDate localDate02 = LocalDate.of(2020, 1, 1);
        LocalDate localDate03 = LocalDate.of(2020, Month.JANUARY, 1);

        // LocalDate localDate = LocalDate.of(2020, Calendar.JANUARY, 1); // does not compile
        // LocalDate localDate = LocalDate.of(2020, 13, 1); // throws DateTimeException
        // LocalDate localDate = LocalDate.of(2020, 1, 31); // throws DateTimeException

        LocalTime localTime01 = LocalTime.now();
        LocalTime localTime02 = LocalTime.of(12, 12);
        LocalTime localTime03 = LocalTime.of(12, 12, 12);
        LocalTime localTime04 = LocalTime.of(12, 12, 12, 12);

        // LocalTime localTime = LocalTime.of(24, 12, 12, 12); // throws DateTimeException
        // LocalTime localTime = LocalTime.of(12, 60, 12, 12); // throws DateTimeException
        // LocalTime localTime = LocalTime.of(12, 12, 60, 12); // throws DateTimeException
        // LocalTime localTime = LocalTime.of(12, 12, 12, Integer.MAX_VALUE); // throws DateTimeException

        LocalDateTime localDateTime01 = LocalDateTime.now();
        LocalDateTime localDateTime02 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime localDateTime03 = LocalDateTime.of(2020, 1, 1, 12, 12);
        LocalDateTime localDateTime04 = LocalDateTime.of(2020, 1, 1, 12, 12, 12);
        LocalDateTime localDateTime05 = LocalDateTime.of(2020, 1, 1, 12, 12, 12, 12);
        LocalDateTime localDateTime06 = LocalDateTime.of(2020, Month.JANUARY, 1, 12, 12);
        LocalDateTime localDateTime07 = LocalDateTime.of(2020, Month.JANUARY, 1, 12, 12, 12);
        LocalDateTime localDateTime08 = LocalDateTime.of(2020, Month.JANUARY, 1, 12, 12, 12, 12);

        // LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), null); // throws NullPointerException
        // LocalDateTime localDateTime = LocalDateTime.of(null, LocalTime.now()); // throws NullPointerException

        ZoneId zoneId1 = ZoneId.systemDefault();
        ZoneId zoneId2 = ZoneId.of("US/Eastern");

        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        ZonedDateTime zonedDateTime01 = ZonedDateTime.of(2020, 1, 1, 12, 12, 12, 12, zoneId1);
        ZonedDateTime zonedDateTime02 = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zoneId1);
        ZonedDateTime zonedDateTime03 = ZonedDateTime.of(LocalDateTime.now(), zoneId1);
        ZonedDateTime zonedDateTime04 = LocalDateTime.now().atZone(zoneId1);

        // ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, 1, 1, 12, 12, zoneId1); // does not compile
        // ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, 1, 1, 12, 12, 12, zoneId1); // does not compile
        // ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, Month.JANUARY, 1, 12, 12, zoneId1); // does not compile
        // ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, Month.JANUARY, 1, 12, 12, 12, zoneId1); // does not compile
        // ZonedDateTime zonedDateTime = ZonedDateTime.of(2020, Month.JANUARY, 1, 12, 12, 12, 12, zoneId1); // does not compile
    }

    private static void getters() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getYear());
        System.out.println(zonedDateTime.getMonthValue());
        System.out.println(zonedDateTime.getMonth());
        System.out.println(zonedDateTime.getDayOfYear());
        System.out.println(zonedDateTime.getDayOfMonth());
        System.out.println(zonedDateTime.getDayOfWeek());
        System.out.println(zonedDateTime.getHour());
        System.out.println(zonedDateTime.getMinute());
        System.out.println(zonedDateTime.getSecond());
        System.out.println(zonedDateTime.getNano());
    }

    private static void conversion() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        localDate = zonedDateTime.toLocalDate();
        localTime = zonedDateTime.toLocalTime();

        localDateTime = zonedDateTime.toLocalDateTime();
        zonedDateTime = localDateTime.atZone(ZoneId.of("US/Eastern"));
    }

    private static void manipulation() {
        LocalDate localDate = LocalDate.now();

        localDate = localDate.plusDays(1);
        localDate = localDate.plusWeeks(1);
        localDate = localDate.plusMonths(1);
        localDate = localDate.plusYears(1);

        localDate = localDate.minusDays(1);
        localDate = localDate.minusWeeks(1);
        localDate = localDate.minusMonths(1);
        localDate = localDate.minusYears(1);

        LocalTime localTime = LocalTime.now();

        localTime = localTime.plusNanos(1);
        localTime = localTime.plusSeconds(1);
        localTime = localTime.plusMinutes(1);
        localTime = localTime.plusHours(1);

        localTime = localTime.minusNanos(1);
        localTime = localTime.minusSeconds(1);
        localTime = localTime.minusMinutes(1);
        localTime = localTime.minusHours(1);

        LocalDateTime localDateTime = LocalDateTime.now();

        localDateTime = localDateTime.plusNanos(1);
        localDateTime = localDateTime.plusSeconds(1);
        localDateTime = localDateTime.plusMinutes(1);
        localDateTime = localDateTime.plusHours(1);
        localDateTime = localDateTime.plusDays(1);
        localDateTime = localDateTime.plusWeeks(1);
        localDateTime = localDateTime.plusMonths(1);
        localDateTime = localDateTime.plusYears(1);

        localDateTime = localDateTime.minusNanos(1);
        localDateTime = localDateTime.minusSeconds(1);
        localDateTime = localDateTime.minusMinutes(1);
        localDateTime = localDateTime.minusHours(1);
        localDateTime = localDateTime.minusDays(1);
        localDateTime = localDateTime.minusWeeks(1);
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minusYears(1);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        zonedDateTime = zonedDateTime.plusNanos(1);
        zonedDateTime = zonedDateTime.plusSeconds(1);
        zonedDateTime = zonedDateTime.plusMinutes(1);
        zonedDateTime = zonedDateTime.plusHours(1);
        zonedDateTime = zonedDateTime.plusDays(1);
        zonedDateTime = zonedDateTime.plusWeeks(1);
        zonedDateTime = zonedDateTime.plusMonths(1);
        zonedDateTime = zonedDateTime.plusYears(1);

        zonedDateTime = zonedDateTime.minusNanos(1);
        zonedDateTime = zonedDateTime.minusSeconds(1);
        zonedDateTime = zonedDateTime.minusMinutes(1);
        zonedDateTime = zonedDateTime.minusHours(1);
        zonedDateTime = zonedDateTime.minusDays(1);
        zonedDateTime = zonedDateTime.minusWeeks(1);
        zonedDateTime = zonedDateTime.minusMonths(1);
        zonedDateTime = zonedDateTime.minusYears(1);

        System.out.println(LocalTime.now().plus(Duration.ofHours(24)));
        System.out.println(LocalTime.now().plus(Duration.ofDays(1)));
        // System.out.println(LocalTime.now().plus(Period.ofDays(1))); // UnsupportedTemporalTypeException

        System.out.println(LocalDate.now().plus(Period.ofMonths(12)));
        System.out.println(LocalDate.now().plus(Period.ofDays(1)));
        // System.out.println(LocalDate.now().plus(Duration.ofDays(1))); // UnsupportedTemporalTypeException

        System.out.println(LocalDateTime.now().plus(Duration.ofHours(12)));
        System.out.println(LocalDateTime.now().plus(Duration.ofDays(1)));
        System.out.println(LocalDateTime.now().plus(Period.ofDays(1)));
        System.out.println(LocalDateTime.now().plus(Period.ofMonths(12)));

        System.out.println(ZonedDateTime.now().plus(Duration.ofHours(12)));
        System.out.println(ZonedDateTime.now().plus(Duration.ofDays(1)));
        System.out.println(ZonedDateTime.now().plus(Period.ofDays(1)));
        System.out.println(ZonedDateTime.now().plus(Period.ofMonths(12)));

        System.out.println(LocalTime.now().minus(Duration.ofHours(24)));
        System.out.println(LocalTime.now().minus(Duration.ofDays(1)));
        // System.out.println(LocalTime.now().minus(Period.ofDays(1))); // UnsupportedTemporalTypeException

        System.out.println(LocalDate.now().minus(Period.ofMonths(12)));
        System.out.println(LocalDate.now().minus(Period.ofDays(1)));
        // System.out.println(LocalDate.now().minus(Duration.ofDays(1))); // UnsupportedTemporalTypeException

        System.out.println(LocalDateTime.now().minus(Duration.ofHours(12)));
        System.out.println(LocalDateTime.now().minus(Duration.ofDays(1)));
        System.out.println(LocalDateTime.now().minus(Period.ofDays(1)));
        System.out.println(LocalDateTime.now().minus(Period.ofMonths(12)));

        System.out.println(ZonedDateTime.now().minus(Duration.ofHours(12)));
        System.out.println(ZonedDateTime.now().minus(Duration.ofDays(1)));
        System.out.println(ZonedDateTime.now().minus(Period.ofDays(1)));
        System.out.println(ZonedDateTime.now().minus(Period.ofMonths(12)));
    }

    private static void epoch() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toEpochDay());

        LocalTime localTime = LocalTime.now();

        // System.out.println(localDate.toEpochSecond(localTime, ZoneOffset.UTC)); // JDK 9
        // System.out.println(localTime.toEpochSecond(localDate, ZoneOffset.UTC)); // JDK 9

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println(localDateTime.toEpochSecond(ZoneOffset.UTC));
        System.out.println(zonedDateTime.toEpochSecond());
    }

    private static void duration() {
        System.out.println(Duration.ofDays(1));
        System.out.println(Duration.ofHours(1));
        System.out.println(Duration.ofMinutes(1));
        System.out.println(Duration.ofSeconds(1));
        System.out.println(Duration.ofMillis(1));
        System.out.println(Duration.ofNanos(1));
        System.out.println(Duration.of(1, ChronoUnit.DAYS));
        System.out.println(Duration.of(1, ChronoUnit.HOURS));
        System.out.println(Duration.of(1, ChronoUnit.MINUTES));
        System.out.println(Duration.of(1, ChronoUnit.SECONDS));
        System.out.println(Duration.of(1, ChronoUnit.MILLIS));
        System.out.println(Duration.of(1, ChronoUnit.NANOS));

        System.out.println(Duration.ofDays(1)); // PT24H
        System.out.println(Duration.ofHours(24)); // PT24H
        System.out.println(Duration.ofMinutes(60)); // PT1H
        System.out.println(Duration.ofSeconds(60)); // PT1M
        System.out.println(Duration.ofMillis(1000)); // PT1S
        System.out.println(Duration.ofNanos(1000000000L)); // PT1S
        System.out.println(Duration.of(1, ChronoUnit.DAYS)); // PT24H
        System.out.println(Duration.of(24, ChronoUnit.HOURS)); // PT24H
        System.out.println(Duration.of(60, ChronoUnit.MINUTES)); // PT1H
        System.out.println(Duration.of(60, ChronoUnit.SECONDS)); // PT1M
        System.out.println(Duration.of(1000, ChronoUnit.MILLIS)); // PT1S
        System.out.println(Duration.of(1000000000L, ChronoUnit.NANOS)); //PT1S

        System.out.println(Duration.parse("PT25H61M74S")); // PT26H2M14S
    }

    private static void period() {
        System.out.println(Period.ofYears(1));
        System.out.println(Period.ofMonths(12));
        System.out.println(Period.ofWeeks(2));
        System.out.println(Period.ofDays(31));
        System.out.println(Period.of(1, 1, 1));
        System.out.println(Period.parse("P1Y1M1D"));
    }

    private static void between() {
        System.out.println(ChronoUnit.YEARS.between(LocalDate.now(), LocalDate.now()));
        System.out.println(ChronoUnit.MONTHS.between(LocalDate.now(), LocalDate.now()));
        System.out.println(ChronoUnit.WEEKS.between(LocalDate.now(), LocalDate.now()));
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now()));

        System.out.println(ChronoUnit.HOURS.between(LocalTime.now(), LocalTime.now()));
        System.out.println(ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.now()));
        System.out.println(ChronoUnit.SECONDS.between(LocalTime.now(), LocalTime.now()));

        // System.out.println(ChronoUnit.YEARS.between(LocalTime.now(), LocalTime.now())); // UnsupportedTemporalTypeException
        // System.out.println(ChronoUnit.MONTHS.between(LocalTime.now(), LocalTime.now())); // UnsupportedTemporalTypeException
        // System.out.println(ChronoUnit.WEEKS.between(LocalTime.now(), LocalTime.now())); // UnsupportedTemporalTypeException
        // System.out.println(ChronoUnit.DAYS.between(LocalTime.now(), LocalTime.now())); // UnsupportedTemporalTypeException

        // System.out.println(ChronoUnit.HOURS.between(LocalDate.now(), LocalDate.now())); // UnsupportedTemporalTypeException
        // System.out.println(ChronoUnit.MINUTES.between(LocalDate.now(), LocalDate.now())); // UnsupportedTemporalTypeException
        // System.out.println(ChronoUnit.SECONDS.between(LocalDate.now(), LocalDate.now())); // UnsupportedTemporalTypeException
    }
}
