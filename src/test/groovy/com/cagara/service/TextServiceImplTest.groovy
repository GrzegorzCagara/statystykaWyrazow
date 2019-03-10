package com.cagara.service

import com.cagara.dto.WordStatistic
import spock.lang.Specification
import spock.lang.Unroll

class TextServiceImplTest extends Specification {

    private static final String TEXT_CONTAINING_2_SENTENCES = "This is sentece1. Sentece2?"
    private static final String TEXT_CONTAINING_3_SENTENCES = "This is sentece1. Sentece2? Another,123123 sentence3!"
    private static
    final String TEXT_CONTAINING_4_SENTENCES = "This is sentece1. Sentece2? Another,123123 sentence3! And sentenceNumber4?"

    private static final String TEXT_CONITANING_5_WHITESPACES = "This is 5  whitespaces "
    private static final String TEXT_CONITANING_3_WHITESPACES = "ThisIs3   whitespaces"
    private static final String TEXT_CONITANING_2_WHITESPACES = " ThisIs3 whitespaces"
    private static final String TEXT_CONITANING_0_WHITESPACES = "NoWhiteSpaces"


    private static final String TEXT_CONTAINING_4_CHARACTERS = "AAAA"
    private static final String TEXT_CONTAINING_5_CHARACTERS = "A_B_C"
    private static final String TEXT_CONTAINING_8_CHARACTERS = "AA BB CC DD"
    private static final String TEXT_CONTAINING_10_CHARACTERS = "aaa    ccc dfgh  "

    private static final String TEXT_CONTAINING_4_NON_ALPHABET = "AAA-!?.CD"
    private static final String TEXT_CONTAINING_7_NON_ALPHABET = "ASD!--**,."
    private static final String TEXT_CONTAINING_8_NON_ALPHABET = "-!?CCC:;'\".XXX"

    private static final ONE_WORD_GREATER_THAN_5_LETTERS = "Cat, dog, fish, hippopotamus"
    private static final TWO_WORD_GREATER_THAN_5_LETTERS = "Cat, dog, fish, hippopotamus penguin"
    private static final THREE_WORD_GREATER_THAN_5_LETTERS = "Cat, dog, fish, hippopotamus, penguin, porpoise, rat"


    TextService sut = new TextServiceImpl()

    @Unroll
    def "should return numberOfSentences: #expectedResult on #text"() {
        expect:
        sut.getNumberOfSentence(text) == expectedResult

        where:
        text                        || expectedResult
        ""                          || 0
        TEXT_CONTAINING_2_SENTENCES || 2
        TEXT_CONTAINING_3_SENTENCES || 3
        TEXT_CONTAINING_4_SENTENCES || 4
        null                        || 0
    }

    @Unroll
    def "should return numberOWhiteSpaces: #expectedResult on #text"() {
        expect:
        sut.getNumberOfWhiteSpace(text) == expectedResult

        where:
        text                          || expectedResult
        ""                            || 0
        TEXT_CONITANING_0_WHITESPACES || 0
        TEXT_CONITANING_2_WHITESPACES || 2
        TEXT_CONITANING_3_WHITESPACES || 3
        TEXT_CONITANING_5_WHITESPACES || 5
        null                          || 0
    }

    @Unroll
    def "should return total number of all characters: #expectedResult on #text"() {
        expect:
        sut.getNumberOfAllCharacter(text) == expectedResult

        where:
        text                          || expectedResult
        ""                            || 0
        TEXT_CONTAINING_4_CHARACTERS  || 4
        TEXT_CONTAINING_5_CHARACTERS  || 5
        TEXT_CONTAINING_8_CHARACTERS  || 8
        TEXT_CONTAINING_10_CHARACTERS || 10
        null                          || 0
    }

    @Unroll
    def "should return number of non alphabet character: #expectedResult on #text"() {
        expect:
        sut.getNumberOfNonAlphabeticCharacter(text) == expectedResult

        where:
        text                           || expectedResult
        ""                             || 0
        TEXT_CONTAINING_4_NON_ALPHABET || 4
        TEXT_CONTAINING_7_NON_ALPHABET || 7
        TEXT_CONTAINING_8_NON_ALPHABET || 8
        null                           || 0
    }


    @Unroll
    def "should return words greater than numberOfLetters: #numberOfLetter"() {
        given:


        expect:
        sut.getWordsGreaterThan(text, 5) == expectedResult

        where:
        text                              || expectedResult
        ""                                || []
        ONE_WORD_GREATER_THAN_5_LETTERS   || ["hippopotamus"]
        TWO_WORD_GREATER_THAN_5_LETTERS   || ["hippopotamus", "penguin"]
        THREE_WORD_GREATER_THAN_5_LETTERS || ["hippopotamus", "penguin", "porpoise"]
        null                              || []
    }



}
