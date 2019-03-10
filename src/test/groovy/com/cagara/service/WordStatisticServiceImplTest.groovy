package com.cagara.service

import com.cagara.dto.Statistics
import spock.lang.Specification

class WordStatisticServiceImplTest extends Specification {

    private static long NUMBER_OF_SENTENCE = 3
    private static long NUMBER_OF_WHITE_SPACES = 10
    private static long NUMBER_OF_ALL_CHARACTER = 30
    private static long NUMBER_OF_NON_ALPHABETIC_CHARACTER = 15


    private TextService textService = Mock()

    private WordStatisticService sut = new WordStatisticServiceImpl(textService)

    def "should calculate statistics"() {
        given:
        Statistics expectedResult =
                Statistics.builder()
                .numberOfSentence(NUMBER_OF_SENTENCE)
                .numberOfWhiteSpace(NUMBER_OF_WHITE_SPACES)
                .numberOfAllCharacter(NUMBER_OF_ALL_CHARACTER)
                .numberOfNonAlphabeticCharacter(NUMBER_OF_NON_ALPHABETIC_CHARACTER)
                .build()

        when:
        1 * textService.getNumberOfSentence(_ as String) >> NUMBER_OF_SENTENCE
        1 * textService.getNumberOfWhiteSpace(_ as String) >> NUMBER_OF_WHITE_SPACES
        1 * textService.getNumberOfAllCharacter(_ as String) >> NUMBER_OF_ALL_CHARACTER
        1 * textService.getNumberOfNonAlphabeticCharacter(_ as String) >> NUMBER_OF_NON_ALPHABETIC_CHARACTER

        then:
        expectedResult == sut.calculateStatistics(_ as String)
    }
}
