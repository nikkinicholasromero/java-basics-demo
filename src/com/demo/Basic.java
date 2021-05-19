package com.demo;

public class Basic {
    public static void main(String[] args) {
        double a = 1.1;
        // float b = 1.1; // does not compile because literal with decimal places are considered double
        Double c = new Double(1.1);
        Float d = new Float(1.1); // compiles because the Float constructor accepts double
    }
}
