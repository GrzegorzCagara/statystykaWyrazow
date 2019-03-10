package com.cagara.service;

import com.cagara.dto.Statistics;
import com.cagara.dto.WordStatistics;

public interface WordStatisticService {

    Statistics calculateStatistics(String text);
}
