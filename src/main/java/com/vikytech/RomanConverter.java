package com.vikytech;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class RomanConverter {

  private static final Map<Character, Integer> romanSymbols = new HashMap<Character, Integer>() {
    {
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }
  };

  public Integer convertRomanToArabicNumber(String roman) {
    roman = roman.toUpperCase();

    int sum = 0;
    int current;
    int previous = 0;

    int index = roman.length() - 1;
    while (index >= 0) {

      try {
        current = getSymbolValue(roman, index);
      } catch (NullPointerException e) {
        throw new IllegalArgumentException(
          format("Invalid roman character %s ", getCharValue(roman, index)));
      }

      if (current < previous) {
        sum -= current;
      } else {
        sum += current;
      }
      previous = current;
      index--;
    }

    return validateSum(sum);
  }

  public Integer validateSum(int sum) {
    if (sum <= 0)
      return -1;

    return sum;
  }

  private Integer getSymbolValue(String roman, int index) {
    return romanSymbols.get(getCharValue(roman, index));
  }

  private char getCharValue(String roman, int index) {
    return roman.charAt(index);
  }
}