package com.thoughtworks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.thoughtworks.util.StringUtils.isDistinct;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnswerGeneratorTest {
    private static Random mockRandom;

    @BeforeAll
    static void setUp() {
        mockRandom = mock(Random.class);
        when(AnswerGeneratorTest.mockRandom.nextInt(anyInt()))
                .thenReturn(7890)
                .thenReturn(7890);
    }

    @Test
    void return_all_number() {
        AnswerGenerator answerGenerator = new AnswerGenerator(mockRandom);

        String result = answerGenerator.generate();

        result.chars().forEach(i -> assertTrue(Character.isDigit((char) i)));
    }

    @Test
    void return_4_bit_number() {
        AnswerGenerator answerGenerator = new AnswerGenerator(mockRandom);

        String result = answerGenerator.generate();

        assertEquals(4, result.length());
    }

    @Test
    void return_no_repeat_number() {
        AnswerGenerator answerGenerator = new AnswerGenerator(mockRandom);

        String result = answerGenerator.generate();

        assertTrue(isDistinct(result));
    }
}