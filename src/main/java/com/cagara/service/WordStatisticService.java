package com.cagara.service;

import com.cagara.dto.WordStatistic;

import java.util.List;

public interface WordStatisticService {
    List<WordStatistic> findTopTenWordsGreaterThanFiveLetter(String text);
}
