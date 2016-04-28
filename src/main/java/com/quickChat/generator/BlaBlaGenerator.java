package com.quickChat.generator;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by dima on 28.04.16.
 */

@Service
public class BlaBlaGenerator implements MessageGeneratorService {
    private static final Integer MAX_WORDS = 10;
    private final String ENDING = "bla bla!";
    private final Integer MAX_SEQUENTIAL_CONSONANTS = 2;
    private final Integer MAX_SYLLABLES = 3;
    private final String SEPARATOR = " ";

    private List<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private List<Character> consonants = new ArrayList<Character>();
    private Random rand = new Random();

    private void initConsonants() {
        for (char i = 'a'; i <= 'z'; i++) {
            if (!vowels.contains(i)) {
                consonants.add(i);
            }
        }
    }

    private String getSyllable() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rand.nextInt(MAX_SEQUENTIAL_CONSONANTS); i++) {
            sb.append(consonants.get(rand.nextInt(consonants.size() - 1)));
        }

        sb.append(vowels.get(rand.nextInt(vowels.size() - 1)));
        return sb.toString();
    }

    private String getNewWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rand.nextInt(MAX_SYLLABLES) + 1; i++) {
            sb.append(getSyllable());
        }

        return sb.toString();
    }

    public BlaBlaGenerator() {
        initConsonants();
    }

    @Override
    public String getNewMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rand.nextInt(MAX_WORDS) + 5; i++) {
            sb.append(getNewWord());
            sb.append(SEPARATOR);
        }

        sb.append(ENDING);
        return sb.toString();
    }
}
