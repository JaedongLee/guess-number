package com.thoughtworks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GuessNumberTest {
    private static AnswerGenerator answerGenerator;

    @BeforeAll
    static void setUp() {
        answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn("1234");
    }

    @Test
    void return_total_A_zero_B_when_number_all_right_and_location_all_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("1234");

        assertEquals("4A0B", result);
    }

    @Test
    void return_n_A_4_sub_n_B_when_number_all_right_and_location_part_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("1342");

        assertEquals("1A3B", result);
    }

    @Test
    void return_0_A_total_B_when_number_all_right_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("4123");

        assertEquals("0A4B", result);
    }

    @Test
    void return_n_A_m_B_n_plus_m_less_than_4_when_number_part_right_and_location_part_right() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("8246");

        assertEquals("1A1B", result);
    }

    @Test
    void return_0_A_n_B_n_less_than_4_when_number_part_right_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("4389");

        assertEquals("0A2B", result);
    }

    @Test
    void return_0_A_0_B_when_number_all_wrong_and_location_all_wrong() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        String result = guessNumber.guess("9567");

        assertEquals("0A0B", result);
    }

    @Test
    void throw_IllegalArgumentException_when_number_duplicate() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        assertThrows(IllegalArgumentException.class, () -> guessNumber.guess("1175"));
    }

    @Test
    void throw_IllegalArgumentException_when_number_count_lower_than_four() {
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();

        assertThrows(IllegalArgumentException.class, () -> guessNumber.guess("12"));
    }
}