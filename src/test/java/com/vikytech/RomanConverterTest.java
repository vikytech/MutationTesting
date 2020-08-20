package com.vikytech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.vikytech.RomanConverter.convertRomanToArabicNumber;


class RomanConverterTest {

    @Test
    void convertI() {
        assertEquals(1, convertRomanToArabicNumber("I"),
          "Roman I should equal to 1");
    }

    @Test
    void convertII() {
        assertEquals(2, convertRomanToArabicNumber("II"),
          "Roman II should equal to 2");
    }

    @Test
    void convertIII() {
        assertEquals(3, convertRomanToArabicNumber("III"),
          "Roman III should equal to 3");
    }

    @Test
    void convertV() {
        assertEquals(5, convertRomanToArabicNumber("V"),
          "Roman V should equal to 5");
    }

    @Test
    void convertVI() {
        assertEquals(6, convertRomanToArabicNumber("VI"),
          "Roman VI should equal to 6");
    }

    @Test
    void convertIV() {
        assertEquals(4, convertRomanToArabicNumber("IV"),
          "Roman IV should equal to 4");
    }

    @Test
    void convertX() {
        assertEquals(10, convertRomanToArabicNumber("X"),
          "Roman X should equal to 10");
    }

    @Test
    void convertIX() {
        assertEquals(9, convertRomanToArabicNumber("IX"),
          "Roman IX should equal to 9");
    }

    @Test
    void convertXXXVI() {
        assertEquals(36, convertRomanToArabicNumber("XXXVI"),
          "Roman XXXVI should equal to 36");
    }

    @Test
    void convertMMXII() {
        assertEquals(2012, convertRomanToArabicNumber("MMXII"),
          "Roman MMXII should equal to 2012");
    }

    @Test
    void convertMCMXCVI() {
        assertEquals(1996, convertRomanToArabicNumber("MCMXCVI"),
          "Roman MCMXCVI should equal to " +
            "1996");
    }

    @Test
    void convertInvalidRomanValue() {
        assertThrows(
          IllegalArgumentException.class,
          () -> convertRomanToArabicNumber("Z"),
          "Invalid roman character Z Should throw (IllegalArgumentException)");
    }

    @Test
    void convertVII() {
        assertEquals(7, convertRomanToArabicNumber("vii"),
          "Roman VII should equal to 7");
    }
}