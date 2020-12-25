package com.thoughtworks;

import java.util.Random;

import static com.thoughtworks.util.StringUtils.isDistinct;

public class AnswerGenerator {
    private final Random random;

    public AnswerGenerator(Random random) {
        this.random = random;
    }

    public AnswerGenerator() {
        this.random = new Random();
    }

    public String generate() {
        String answer = String.format("%04d", this.random.nextInt(10000));
        if (isDistinct(answer)) {
            return answer;
        }
        return generate();
    }

}
