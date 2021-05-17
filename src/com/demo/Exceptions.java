package com.demo;

public class Exceptions {
    public static void main(String[] args) {
    }

    private static void builtInExceptions() {
        // Runtime Exceptions
        java.lang.ArithmeticException arithmeticException; // thrown by the JVM
        java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException; // thrown by the JVM
        java.lang.ClassCastException classCastException; // thrown by the JVM
        java.lang.NullPointerException nullPointerException; // thrown by the JVM
        java.lang.ArrayStoreException arrayStoreException; // thrown by the JVM
        java.lang.IllegalStateException illegalStateException; // programmatically thrown
        java.lang.IllegalArgumentException illegalArgumentException; // programmatically thrown
        java.lang.NumberFormatException numberFormatException; // programmatically thrown

        java.lang.UnsupportedOperationException unsupportedOperationException; // programmatically thrown
        java.time.DateTimeException dateTimeException; // programmatically thrown
        java.util.MissingResourceException missingResourceException; // programmatically thrown

        // Checked Exceptions
        java.text.ParseException parseException; // programmatically thrown
        java.io.FileNotFoundException fileNotFoundException; // programmatically thrown
        java.io.IOException ioException; // programmatically thrown
        java.io.NotSerializableException notSerializableException; // programmatically thrown
        java.sql.SQLException sqlException; // programmatically thrown
    }
}
