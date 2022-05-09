//https://www.codewars.com/kata/526571aae218b8ee490006f4

package com.jokieh.kyu_6;

public class BitCounting {

    public static int countBits(int n){

        int onesCounter = 0;
        String nString = Integer.toBinaryString(n);

        for (char c: nString.toCharArray()
        ) {
            if (c == '1') {
                onesCounter++;
            }
        }

        return onesCounter;
    }

}
