package com.example.praktikos_darbas_2;

import java.util.Arrays;

public class LengthCalculator {
    public static int CalculateChars(String input){
        return input.length();
    }

    public static int CalculateWords(String input){
        String[] words = input.split(" ");
        words = Arrays.stream(words)
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);

        return words.length;
    }
}
