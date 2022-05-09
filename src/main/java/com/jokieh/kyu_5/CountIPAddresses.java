package com.jokieh.kyu_5;

public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {

        long startValue = stringToBase10Value(start);
        long endValue = stringToBase10Value(end);

        return endValue - startValue;

    }

    private static long stringToBase10Value (String ipAddress) {

        String[] ipStringArray = ipAddress.split("\\.");

        int[] ipIntArray = new int[4];

        int i = 3;

        for (String string : ipStringArray) {

            ipIntArray[i] = Integer.parseInt(string);
            i--;

        }

        return base256ValueConverter(ipIntArray);

    }

    private static long base256ValueConverter (int[] ipArray) {

        double value = 0;

        for (int i=0; i<=3; i++) {

            value = value + (ipArray[i] * Math.pow(256,i));

        }

        return (long) value;

    }

}
