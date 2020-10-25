package com.vikytech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanConverterTest {

    private RomanConverter romanConvertor;

    @Test
    void convertI() {
        romanConvertor = new RomanConverter();
        assertEquals(1, romanConvertor.convertRomanToArabicNumber("I"),
          "Roman I should equal to 1");
    }

}