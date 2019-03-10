package com.cagara.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TextServiceImpl implements TextService {


    @Override
    public long getNumberOfSentence(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.split("[!?.:]+").length;
    }

    @Override
    public long getNumberOfWhiteSpace(String text) {
        if (text == null) {
            return 0;
        }
        return text
                .chars()
                .filter(Character::isWhitespace)
                .count();
    }

    @Override
    public long getNumberOfAllCharacter(String text) {
        if (text == null) {
            return 0;
        }
        return text.length() - getNumberOfWhiteSpace(text);
    }

    @Override
    public long getNumberOfNonAlphabeticCharacter(String text) {
        if (text == null) {
            return 0;
        }
        return text
                .chars()
                .filter(character -> !Character.isAlphabetic(character))
                .count();
    }

    @Override
    public List<String> getWordsGreaterThan(String text, Integer numberOfLetters) {
        if (text == null) {
            return Collections.emptyList();
        }
        List<String> words = new ArrayList<>();
        Pattern p = Pattern.compile("[a-zA-Z']{" + numberOfLetters + ",}");
        Matcher m = p.matcher(text);
        while (m.find()) {
            words.add(m.group());
        }
        return words;
    }


}
