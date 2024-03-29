package com.example.praktikos_darbas_2;

import java.util.Arrays;

public class LengthCalculator {
    public static int CalculateChars(String input){
        if (input == null){
            throw new IllegalArgumentException();
        }

        return input.length();
    }

    public static int CalculateWords(String input){
        if (input == null){
            throw new IllegalArgumentException();
        }

        String[] words = input.split("\\s+");
        words = Arrays.stream(words)
                .filter(str -> !str.isEmpty())
                .toArray(String[]::new);

        return words.length;
    }
}
