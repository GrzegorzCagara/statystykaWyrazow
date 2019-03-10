package com.cagara.service

import com.cagara.dto.AlphabetStatistic
import spock.lang.Specification

class AlphabetStatisticServiceImplTest extends Specification {


    private AlphabetStatisticService alphabetStatisticService = new AlphabetStatisticServiceImpl()


    def "should "() {
        given:
        String text = "alla ma kota i psa, ma słoń. Tygrys i żółw kot"

        when:
        List<AlphabetStatistic> result = alphabetStatisticService.findTopTenAlphabetCharacters(text)

        then:
        result.contains(AlphabetStatistic.of("a", 6)) == true
        result.contains(AlphabetStatistic.of("l", 2)) == true
        result.contains(AlphabetStatistic.of("m", 2)) == true
        result.contains(AlphabetStatistic.of("k", 2)) == true
        result.contains(AlphabetStatistic.of("o", 3)) == true
        result.contains(AlphabetStatistic.of("z", 0)) == false
    }
}
