package com.demo;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle rb = ResourceBundle.getBundle("Buggy");
        System.out.println(rb.getString("wheels"));
        System.out.println(rb.getString("color"));
    }
}

// java class resource bundle package name in ResourceBundle.getBundle
