package com.vikytech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanConverterTest {

  private RomanConverter romanConvertor;

  @BeforeEach
  void setUp() {
    romanConvertor = new RomanConverter();
  }

  @Test
  void convertI() {
    assertEquals(1, romanConvertor.convertRomanToArabicNumber("I"),
      "Roman I should equal to 1");
  }

  @Test
  void convertII() {
    assertEquals(2, romanConvertor.convertRomanToArabicNumber("II"),
      "Roman II should equal to 2");
  }

  @Test
  void convertIII() {
    assertEquals(3, romanConvertor.convertRomanToArabicNumber("III"),
      "Roman III should equal to 3");
  }

  @Test
  void convertIV() {
    assertEquals(4, romanConvertor.convertRomanToArabicNumber("IV"),
      "Roman IV should equal to 4");
  }

  @Test
  void convertV() {
    assertEquals(5, romanConvertor.convertRomanToArabicNumber("V"),
      "Roman V should equal to 5");
  }

  @Test
  void convertVI() {
    assertEquals(6, romanConvertor.convertRomanToArabicNumber("VI"),
      "Roman VI should equal to 6");
  }

  @Test
  void convertVII() {
    assertEquals(7, romanConvertor.convertRomanToArabicNumber("vii"),
      "Roman VII should equal to 7");
  }

  @Test
  void convertIX() {
    assertEquals(9, romanConvertor.convertRomanToArabicNumber("IX"),
      "Roman IX should equal to 9");
  }

  @Test
  void convertX() {
    assertEquals(10, romanConvertor.convertRomanToArabicNumber("X"),
      "Roman X should equal to 10");
  }

  @Test
  void convertXXXVI() {
    assertEquals(36, romanConvertor.convertRomanToArabicNumber("XXXVI"),
      "Roman XXXVI should equal to 36");
  }

  @Test
  void convertMMXII() {
    assertEquals(2012, romanConvertor.convertRomanToArabicNumber("MMXII"),
      "Roman MMXII should equal to 2012");
  }

  @Test
  void convertMCMXCVI() {
    assertEquals(1996, romanConvertor.convertRomanToArabicNumber("MCMXCVI"),
      "Roman MCMXCVI should equal to 1996");
  }

  @Test
  void convertInvalidRomanValue() {
    assertThrows(
      IllegalArgumentException.class,
      () -> romanConvertor.convertRomanToArabicNumber("Z"),
      "Invalid roman character Z Should throw (IllegalArgumentException)");
  }

  @Test
  void validateSumWithValidValue() {
    assertEquals(25, romanConvertor.validateSum(25),
      "Should return the same value sent in Parameter");
  }

  @Test
  void validateSumWithZero() {
    romanConvertor.validateSum(0);
  }
}