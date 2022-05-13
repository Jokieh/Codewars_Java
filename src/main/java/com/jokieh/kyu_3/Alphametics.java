//https://www.codewars.com/kata/5b5fe164b88263ad3d00250b

package com.jokieh.kyu_3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Alphametics {

    private LinkedHashMap<Character, Integer> dictionary = new LinkedHashMap<Character, Integer>();
    private ArrayList<Map.Entry<String, Integer>> solutionMap = new ArrayList<Map.Entry<String, Integer>>();
    private Boolean isFirstLetter = true;
    double iterations = 0;

    public Alphametics(String s) {

        initializeDictionary(s);
        initializeSolutionMap(s);

        Boolean validSolution = false;

        while (!validSolution) {

            randomizeDictionary();
            mapCharacters();

            validSolution = validateSolution();

            iterations++;
            System.out.println(iterations);


        }


    }

    public String solve() {

        StringBuilder solutionString = new StringBuilder();

        solutionString.append(solutionMap.get(0).getValue().toString() + " + ");
        solutionString.append(solutionMap.get(1).getValue().toString() + " = ");
        solutionString.append(solutionMap.get(2).getValue().toString());

        return solutionString.toString();
    }

    private void initializeDictionary (String inputString) {

        for (Character c: inputString.toCharArray()) {

            if (!(c.equals('+') || c.equals(' ') || c.equals('='))) {

                    dictionary.put(c , 0);

            }

        }

    }

    private void initializeSolutionMap (String inputString) {

        String [] inputStringArray = inputString.split("\\s[+=]\\s");

        for (int i = 0; i < inputStringArray.length; i++) {

            solutionMap.add(Map.entry(inputStringArray[i], (int) (Math.random()*10)));

        }


    }

    private void randomizeDictionary () {


        isFirstLetter = true;

        dictionary.forEach( (letter, value) -> {


            if (isFirstLetter) {

                do {

                    value = (int) (Math.random()*10);
                    dictionary.replace(letter, value);

                } while (value == 0);

                isFirstLetter = false;

            } else {

                do {

                    value = (int) (Math.random()*10);
                    dictionary.replace(letter, value);

                } while (dictionary.values().contains(value));

            }

        });

    }

    private void mapCharacters () {

        solutionMap.forEach( entry -> {

            String entryKey = entry.getKey();

            Integer entryValue;

            char[] ch = entryKey.toCharArray();

            for (Character c : ch) {
                c = Character.forDigit(dictionary.get(c), 10);
            }

            entryKey = ch.toString();

            entryValue = Integer.valueOf(entryKey);

            entry.setValue(entryValue);

        });

    }

    private Boolean validateSolution () {

        if ((solutionMap.get(0).getValue() + solutionMap.get(1).getValue()) == solutionMap.get(2).getValue()) {
            return true;
        } else return false;

    }



}
