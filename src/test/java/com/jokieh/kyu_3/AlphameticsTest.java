package com.jokieh.kyu_3;

import static org.junit.Assert.*;
import org.junit.Test;

public class AlphameticsTest {

    private static final String[][] fixedTests = {
            {"SEND + MORE = MONEY",                  "9567 + 1085 = 10652"},
            {"ZEROES + ONES = BINARY",               "698392 + 3192 = 701584"},
            {"COUPLE + COUPLE = QUARTET",            "653924 + 653924 = 1307848"},
            {"DO + YOU + FEEL = LUCKY",              "57 + 870 + 9441 = 10368"},
            {"ELEVEN + NINE + FIVE + FIVE = THIRTY", "797275 + 5057 + 4027 + 4027 = 810386"},
    };

    @Test public void FixedTests() {
        for (String[] test: fixedTests)
            assertEquals(test[1], new Alphametics(test[0]).solve());
    }
}