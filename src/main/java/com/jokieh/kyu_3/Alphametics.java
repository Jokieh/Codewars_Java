//https://www.codewars.com/kata/5b5fe164b88263ad3d00250b

package com.jokieh.kyu_3;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Alphametics {

    private LinkedHashMap<Character, Integer> letterValues = new LinkedHashMap<Character, Integer>();

    public Alphametics(String s) {

        initializeHashMap(s);
        randomizeValues();

        String solutionString = replaceWithMappedCharacters(s);

        System.out.println(solutionString);


    }

    public String solve() {
        // Your code here too!!
        return null;
    }

    private void initializeHashMap (String inputString) {

        for (Character c: inputString.toCharArray()) {

            if (!(c.equals('+') || c.equals(' ') || c.equals('='))) {

                    letterValues.put(c , 0);

            }

        }

    }

    private void randomizeValues () {


        AtomicBoolean isFirstLetter = new AtomicBoolean(true);

        letterValues.forEach( (letter, value) -> {

            if (isFirstLetter.get()) {

                do {

                    value = (int) (Math.random() * 10);

                } while (value == 0);

                isFirstLetter.set(false);

            } else {

                do {

                    value = (int) (Math.random() * 10);

                } while (letterValues.values().contains(value));

            }

        });

    }

    private String replaceWithMappedCharacters (String s) {

        for (Character c : s.toCharArray()) {

            if (!(c.equals('+') || c.equals(' ') || c.equals('='))) {

                c = Character.forDigit(letterValues.get(c),10);

            }



        }

        return s;

    }
}
