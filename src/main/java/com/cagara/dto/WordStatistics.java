package com.cagara.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class WordStatistics {

    private final String word;
    private final Integer wordsCount;


    public static WordStatistics of(String word, Integer wordsCount) {
        return WordStatistics.builder()
                .word(word)
                .wordsCount(wordsCount)
                .build();
    }

    @Override
    public String toString() {
        return this.word + " : " + this.wordsCount + "\n";
    }
}
