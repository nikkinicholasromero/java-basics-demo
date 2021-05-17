package com.demo;

public class Exceptions {
    public static void main(String[] args) {
        autoCloseable();
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

class CustomException extends Exception {

}

class CustomRuntimeException extends RuntimeException {

}

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