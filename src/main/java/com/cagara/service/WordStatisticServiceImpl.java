package com.cagara.service;

import com.cagara.dto.WordStatistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordStatisticServiceImpl implements WordStatisticService{

    private final TextService textService;

    public WordStatisticServiceImpl(TextService textService) {
        this.textService = textService;
    }


    @Override
    public List<WordStatistic> findTopTenWordsGreaterThanFiveLetter(String text) {
        List<String> wordsGreaterThanFiveLetters = textService.getWordsGreaterThan(text, 5);
        Map<String, Integer> map = new HashMap<>();
        for (String wordsGreaterThanFiveLetter : wordsGreaterThanFiveLetters) {
            Integer numberOfWords = map.get(wordsGreaterThanFiveLetter) == null ? 0 : map.get(wordsGreaterThanFiveLetter);
            map.put(wordsGreaterThanFiveLetter, numberOfWords + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e2.getValue()
                        .compareTo(e1.getValue())
                )
                .map(e -> WordStatistic.of(e.getKey(), e.getValue()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
