package com.cagara.service;

import com.cagara.dto.Statistics;
import com.cagara.dto.WordStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatisticServiceImpl implements StatisticService {


    private final TextService textService;
    private final WordStatisticService wordStatisticService;
    private final AlphabetStatisticService alphabetStatisticService;

    public StatisticServiceImpl(TextService textService, WordStatisticService wordStatisticService, AlphabetStatisticService alphabetStatisticService) {
        this.textService = textService;
        this.wordStatisticService = wordStatisticService;
        this.alphabetStatisticService = alphabetStatisticService;
    }

    @Override
    public Statistics calculateStatistics(String text) {
        return Statistics.builder()
                .wordStatistics(wordStatisticService.findTopTenWordsGreaterThanFiveLetter(text))
                .numberOfSentence(textService.getNumberOfSentence(text))
                .numberOfWhiteSpace(textService.getNumberOfWhiteSpace(text))
                .numberOfAllCharacter(textService.getNumberOfAllCharacter(text))
                .numberOfNonAlphabeticCharacter(textService.getNumberOfNonAlphabeticCharacter(text))
                .alphabetStatistics(alphabetStatisticService.findTopTenAlphabetCharacters(text))
                .build();
    }





}
