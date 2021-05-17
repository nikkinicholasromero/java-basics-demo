package com.demo;

import java.io.IOException;
import java.sql.SQLException;

public class Exceptions {
    public static void main(String[] args)  {
    }

    private static void generalException() throws IOException, SQLException {
        try {
            throwsExceptions();
        } catch (Exception e) {
            // e here is not effectively final
            // e is inferred to be either IOException or SQLException (from the throwsException signature)
            // if e is re-assigned, e will be considered of type Exception.class. the throw line will not compile anymore
            throw e;
        }
    }

    private static void multicatch() throws IOException, SQLException {
        try {
            throwsExceptions();
        } catch (IOException | SQLException e) {
            // e here is effectively final and cannot be reassigned
            throw e;
        }
    }

    private static void throwsExceptions() throws IOException, SQLException {

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

    private static void autoCloseable() {
        try (CustomAutoCloseableA customAutoCloseableA = new CustomAutoCloseableA();
            CustomAutoCloseableB customAutoCloseableB = new CustomAutoCloseableB()) {
            System.out.println("Running try method");
            throw new RuntimeException();
        } catch (CustomException e) {
            System.out.println("This should only run if the first exception thrown is CustomException " + e);
        } catch (RuntimeException e) {
            System.out.println("Main exception is " + e);

            System.out.println("Suppressed exceptions are :");
            for (Throwable suppressed: e.getSuppressed()) {
                System.out.println(suppressed);
            }
        }
    }
}

class CustomException extends Exception {}

class CustomRuntimeException extends RuntimeException {}

class CustomAutoCloseableA implements AutoCloseable {
    @Override
    public void close() throws CustomException {
        System.out.println("Closing " + this.getClass().getName());
        throw new CustomException();
    }
}

class CustomAutoCloseableB implements AutoCloseable {
    @Override
    public void close() throws CustomRuntimeException {
        System.out.println("Closing " + this.getClass().getName());
        throw new CustomRuntimeException();
    }
}
