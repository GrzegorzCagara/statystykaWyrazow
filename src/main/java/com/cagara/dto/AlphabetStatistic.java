package com.cagara.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class AlphabetStatistic {

    private final String character;
    private final Integer charactersCount;


    public static AlphabetStatistic of(String character, Integer charactersCount) {
        return AlphabetStatistic.builder()
                .character(character)
                .charactersCount(charactersCount)
                .build();
    }
}
