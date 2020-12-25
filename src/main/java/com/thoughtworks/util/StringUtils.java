package com.thoughtworks.util;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isDistinct(String userInput) {
        return userInput.chars().distinct().count() == userInput.length();
    }
}
