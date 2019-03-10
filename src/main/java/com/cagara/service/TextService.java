package com.cagara.service;

import java.util.List;

public interface TextService {

    long getNumberOfSentence(String text);
    long getNumberOfWhiteSpace(String text);
    long getNumberOfAllCharacter(String text);
    long getNumberOfNonAlphabeticCharacter(String text);

    List<String> getWordsGreaterThan(String text, Integer numberOfLetters);
}
