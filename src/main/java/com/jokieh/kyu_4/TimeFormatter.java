//https://www.codewars.com/kata/52742f58faf5485cae000b9a

package com.jokieh.kyu_4;

import java.util.ArrayList;
import java.util.Map;

public class TimeFormatter {

    public static String formatDuration(int seconds) {

        StringBuilder formattedDuration = new StringBuilder();

        int second = 1;
        int minute = 60 * second;
        int hour = 60 * minute;
        int day = 24 * hour;
        int year = 365 * day;

        int remainder;

        ArrayList <Map.Entry<String, Integer>> valuesList = new ArrayList<>();

        valuesList.add(Map.entry("year",seconds / year));
        remainder = seconds % year;
        valuesList.add(Map.entry("day", remainder / day));
        remainder = remainder % day;
        valuesList.add(Map.entry("hour", remainder / hour));
        remainder = remainder % hour;
        valuesList.add(Map.entry("minute", remainder / minute));
        remainder = remainder % minute;
        valuesList.add(Map.entry("second", remainder));

        if (seconds == 0) return "now";

        valuesList.removeIf(pair -> pair.getValue() == 0);

        valuesList.forEach(pair -> {

            String valueKey = pair.getValue() + " " + pair.getKey();

            if (valuesList.indexOf(pair) == 0) {

                formattedDuration.append(valueKey);

            } else if (valuesList.indexOf(pair) == valuesList.size()-1) {

                formattedDuration.append(" and " + valueKey);

            } else {

                formattedDuration.append(", " + valueKey);

            }

            if (pair.getValue() > 1) formattedDuration.append("s");

        });

        return formattedDuration.toString();
    }

}

