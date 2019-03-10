package com.cagara.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class WordStatistic {

    private final String word;
    private final Integer wordsCount;


    public static WordStatistic of(String word, Integer wordsCount) {
        return WordStatistic.builder()
                .word(word)
                .wordsCount(wordsCount)
                .build();
    }
}
