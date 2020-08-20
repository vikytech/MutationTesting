package com.vikytech;

import java.util.HashMap;
import java.util.Map;

final class RomanConverter {

    private static final Map<Character, Integer> romanSymbols = new HashMap<Character, Integer>() {
        private static final long serialVersionUID = 1L;
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

    private RomanConverter() {
    }

    static int convertRomanToArabicNumber(String roman) {

        roman = roman.toUpperCase();

        int sum = 0;
        int current = 0;
        int previous = 0;

        for (int index = roman.length() - 1; index >= 0; index--) {
            if (doesSymbolsContainsRomanCharacter(roman, index)) {

                current = getSymbolValue(roman, index);

                if (current < previous) {
                    sum -= current;
                } else {
                    sum += current;
                }

                previous = current;

            } else {
                throw new IllegalArgumentException(
                  String.format("Invalid roman character %s ", getCharValue(roman, index)));
            }
        }
        return sum;
    }

    private static boolean doesSymbolsContainsRomanCharacter(String roman, int index) {
        return romanSymbols.containsKey(getCharValue(roman, index));
    }

    private static Integer getSymbolValue(String roman, int index) {
        return romanSymbols.get(getCharValue(roman, index));
    }

    private static char getCharValue(String roman, int index) {
        return roman.charAt(index);
    }
}