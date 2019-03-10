package com.cagara.service;

import com.cagara.dto.Statistics;
import com.cagara.dto.WordStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WordStatisticServiceImpl implements WordStatisticService {


    private final TextService textService;

    @Autowired
    public WordStatisticServiceImpl(TextService textService) {
        this.textService = textService;
    }

    @Override
    public Statistics calculateStatistics(String text) {
        long numberOfSentence = textService.getNumberOfSentence(text);
        long numberOfWhiteSpace = textService.getNumberOfWhiteSpace(text);
        long numberOfAllCharacter = textService.getNumberOfAllCharacter(text);
        long numberOfNonAlphabeticCharacter = textService.getNumberOfNonAlphabeticCharacter(text);
        List<WordStatistics> topTenWordsGreaterThanFiveLetter = textService.findTopTenWordsGreaterThanFiveLetter(text);
        return Statistics.builder()
                .wordStatistics(topTenWordsGreaterThanFiveLetter)
                .numberOfSentence(numberOfSentence)
                .numberOfWhiteSpace(numberOfWhiteSpace)
                .numberOfAllCharacter(numberOfAllCharacter)
                .numberOfNonAlphabeticCharacter(numberOfNonAlphabeticCharacter)
                .build();
    }





}
