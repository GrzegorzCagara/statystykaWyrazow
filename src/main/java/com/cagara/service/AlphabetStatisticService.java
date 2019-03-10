package com.cagara.service;

import com.cagara.dto.AlphabetStatistic;

import java.util.List;

public interface AlphabetStatisticService {
    List<AlphabetStatistic> findTopTenAlphabetCharacters(String text);
}
