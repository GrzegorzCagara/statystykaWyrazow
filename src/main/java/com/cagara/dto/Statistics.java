package com.cagara.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Statistics {

    private final List<WordStatistic> wordStatistics;
    private final Long numberOfSentence;
    private final Long numberOfWhiteSpace;
    private final Long numberOfAllCharacter;
    private final Long numberOfNonAlphabeticCharacter;
    private final List<AlphabetStatistic> alphabetStatistics;

    public void printStatistics() {
        String numberOfSentence = String.format("Liczba zdań w tekście: %d", this.numberOfSentence);
        String numberOfWhiteSpace = String.format("Liczba białych znaków w teksćie: %d", this.numberOfWhiteSpace);
        String numberOfAllCharacter = String.format("Liczba wszystkich znaków w tekscie: %d", this.numberOfAllCharacter);
        String numberOfNonAlphabeticCharacter = String.format("Liczba znaków nie będących znakami alfabetu w tekscie: %d", this.numberOfNonAlphabeticCharacter);

        System.out.println("Top 10 wyrazów dłuższych niż 5 liter: \n" +
                formatWordStatistics() + "\n" + numberOfSentence + "\n" + numberOfWhiteSpace + "\n" + numberOfAllCharacter + "\n"
                + numberOfNonAlphabeticCharacter + "\nTop 10 liter alfabetu: \n" + formatAlphabetStatistics());
    }


    private String formatWordStatistics() {
        String result = "";
        int counter = 1;
        for (WordStatistic wordStatistic : wordStatistics) {
            result += "[" + counter + ". " + wordStatistic.getWord() + " : " + wordStatistic.getWordsCount() + "]\n";
            counter++;
        }
        return result;
    }

    private String formatAlphabetStatistics() {
        String result = "";
        int counter = 1;
        for (AlphabetStatistic alphabetStatistic : alphabetStatistics) {
            result += "[" + counter + ". " + alphabetStatistic.getCharacter() + " : " + alphabetStatistic.getCharactersCount() + "]\n";
            counter++;
        }
        return result;
    }
}
