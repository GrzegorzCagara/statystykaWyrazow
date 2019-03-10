package com.cagara.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Statistics {

    private final List<WordStatistics> wordStatistics;
    private final Long numberOfSentence;
    private final Long numberOfWhiteSpace;
    private final Long numberOfAllCharacter;
    private final Long numberOfNonAlphabeticCharacter;

    public void printStatistics() {
        String numberOfSentence = String.format("Liczba zdań w tekście: %d", this.numberOfSentence);
        String numberOfWhiteSpace = String.format("Liczba białych znaków w teksćie: %d", this.numberOfWhiteSpace);
        String numberOfAllCharacter = String.format("Liczba wszystkich znaków w tekscie: %d", this.numberOfAllCharacter);
        String numberOfNonAlphabeticCharacter = String.format("Liczba znaków nie będących znakami alfabetu w tekscie: %d", this.numberOfNonAlphabeticCharacter);

        System.out.println("Top 10 wyrazów dłuższych niż 5 liter: \n" +
                this.wordStatistics + "\n" + numberOfSentence + "\n" + numberOfWhiteSpace + "\n" + numberOfAllCharacter + "\n"
        + numberOfNonAlphabeticCharacter);
    }
}
