package com.thoughtworks;

import cn.hutool.core.util.StrUtil;
import com.thoughtworks.util.StringUtils;

import static cn.hutool.core.util.StrUtil.*;
import static com.thoughtworks.util.StringUtils.*;

public class GuessNumber {
    private final AnswerGenerator answerGenerator;
    private String answer;

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    public static void main(String[] args) {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();
        String guess = guessNumber.guess("1234");
    }

    public String guess(String userInput) {
        if (isBlank(userInput) || userInput.length() < 4 || !isDistinct(userInput)) {
            throw new IllegalArgumentException();
        }
        char[] guessChars = userInput.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < guessChars.length; i++) {
            char guessChar = guessChars[i];
            int index = answer.indexOf(guessChar);
            if (index == i) {
                a++;
                continue;
            }
            if (index >= 0) {
                b++;
            }
        }
        return a + "A" + b + "B";
    }

    public void start() {
        this.answer = answerGenerator.generate();
    }

}
