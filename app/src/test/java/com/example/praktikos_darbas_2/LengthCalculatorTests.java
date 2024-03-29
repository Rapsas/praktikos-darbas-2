package com.example.praktikos_darbas_2;

import org.junit.Assert;
import org.junit.Test;

public class LengthCalculatorTests {

    @Test (expected = IllegalArgumentException.class)
    public void CalculateCharsNullTest(){
        String input = null;
        LengthCalculator.CalculateChars(input);
    }

    @Test
    public void CalculateCharsEmptyTest(){
        String input = "";
        int result = LengthCalculator.CalculateChars(input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void CalculateCharsStandardCaseTest(){
        String input = "123456789";
        int result = LengthCalculator.CalculateChars(input);
        Assert.assertEquals(9, result);
    }

    @Test
    public void CalculateCharsSpacesTest(){
        String input = "   ";
        int result = LengthCalculator.CalculateChars(input);
        Assert.assertEquals(3, result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void CalculateWordsNullTest(){
        String input = null;
        LengthCalculator.CalculateWords(input);
    }

    @Test
    public void CalculateWordsEmptyTest(){
        String input = "";
        int result = LengthCalculator.CalculateWords(input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void CalculateWordsStandardCaseTest(){
        String input = "123 456 789";
        int result = LengthCalculator.CalculateWords(input);
        Assert.assertEquals(3, result);
    }

    @Test
    public void CalculateWordsSpacesTest(){
        String input = "    ";
        int result = LengthCalculator.CalculateWords(input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void CalculateWordsNewLineTest(){
        String input = "\n \n \n \n ";
        int result = LengthCalculator.CalculateWords(input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void CalculateWordsNewLineWithWordsTest(){
        String input = "\n hello\n world\n bim\n bam";
        int result = LengthCalculator.CalculateWords(input);
        Assert.assertEquals(4, result);
    }
}
