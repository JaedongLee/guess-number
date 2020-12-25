package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuessNumberTest {
    private static AnswerGenerator answerGenerator;

    @BeforeAll
    static void setUp() {
        answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
    }

    @Test
    void when_number_all_right_and_location_all_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("1234");

        assertEquals("4A0B", result);
    }

    @Test
    void when_number_all_right_and_location_part_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("1342");

        assertEquals("1A3B", result);
    }

    @Test
    void when_number_all_right_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("4123");

        assertEquals("0A4B", result);
    }

    @Test
    void when_number_part_right_and_location_part_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("8246");

        assertEquals("4A0B", result);
    }

    @Test
    void when_number_part_right_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("4389");

        assertEquals("0A2B", result);
    }

    @Test
    void when_number_all_wrong_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("1567");

        assertEquals("0A0B", result);
    }

    @Test
    void when_number_duplicate() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        assertThrows(NumberDuplicateException.class, () -> guessNumber.guess("1175"));
    }

    @Test
    void when_number_count_lower_than_four() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        assertThrows(NumberCountException.class, () -> guessNumber.guess("12"));
    }
}