//https://www.codewars.com/kata/5b5fe164b88263ad3d00250b

package com.jokieh.kyu_3;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Alphametics {

    private LinkedHashMap<Character, Integer> dictionary = new LinkedHashMap<Character, Integer>();
    private LinkedHashMap<String, Integer> soutionHashMap = new LinkedHashMap<String, Integer>();

    public Alphametics(String s) {

        initializeDictionary(s);
        initializeSolutionHashMap(s);

        randomizeDictionary();

        String solutionString = replaceWithMappedCharacters(s);

        System.out.println(solutionString);


    }

    public String solve() {
        // Your code here too!!
        return null;
    }

    private void initializeDictionary (String inputString) {

        for (Character c: inputString.toCharArray()) {

            if (!(c.equals('+') || c.equals(' ') || c.equals('='))) {

                    dictionary.put(c , 0);

            }

        }

    }

    private void initializeSolutionHashMap (String inputString) {

        inputString.replace(" ","");
        String [] inputStringArray = inputString.split("[+=]");

        for (int i = 0; i < inputStringArray.length; i++) {

            soutionHashMap.put(inputStringArray[i], 0);

        }


    }

    private void randomizeDictionary () {


        AtomicBoolean isFirstLetter = new AtomicBoolean(true);

        dictionary.forEach( (letter, value) -> {

            Random random = new Random();

            if (isFirstLetter.get()) {

                do {

                    value = random.nextInt(10);

                } while (value == 0);

                isFirstLetter.set(false);

            } else {

                do {

                    value = random.nextInt(10);

                } while (dictionary.values().contains(value));

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
