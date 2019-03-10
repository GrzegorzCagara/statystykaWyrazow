package com.cagara.service

import com.cagara.dto.WordStatistic
import spock.lang.Specification
import spock.lang.Unroll

class WordStatisticServiceImplTest extends Specification {


    private TextService textService = Mock()

    private WordStatisticService sut = new WordStatisticServiceImpl(textService)

    @Unroll
    def "should find top 10 words greater than five letters"() {
        given:
        List<String> listOfWordsGreaterThanFiveLetters =
                ["Pancernik", "dinozaur", "orangutan", "krakow", "lezajsk", "lezajsk",
                 "krolik", "Pancernik", "XXXXXX", "Pancernik", "XXXXXX", "XXXXXX", "XXXXXX", "krolik", "krakow", "orangutan",
                 "orangutan", "dinozaur", "orangutan"]

        when:
        textService.getWordsGreaterThan(_ as String, _ as Integer) >> listOfWordsGreaterThanFiveLetters
        List<WordStatistic> result = sut.findTopTenWordsGreaterThanFiveLetter(_ as String)

        then:
        result.contains(WordStatistic.of("kota", 1)) == false
        result.contains(WordStatistic.of("psa", 2)) == false
        result.contains(WordStatistic.of("XXXXXX", 4)) == true
        result.contains(WordStatistic.of("Pancernik", 3)) == true
        result.contains(WordStatistic.of("dinozaur", 2)) == true
        result.contains(WordStatistic.of("orangutan", 4)) == true
        result.contains(WordStatistic.of("krakow", 2)) == true
        result.contains(WordStatistic.of("lezajsk", 2)) == true
        result.contains(WordStatistic.of("krolik", 2)) == true
    }
}
