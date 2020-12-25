package com.thoughtworks;

public class GuessNumber {
    private AnswerGenerator answerGenerator;
    private String answer;

    public GuessNumber(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    public String guess(String userInput){
        //TODO 驱动出下面的代码
        return null;
    }

    public void start() {
        this.answer = answerGenerator.generate();
    }

    public static void main(String[] args){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        GuessNumber guessNumber = new GuessNumber(answerGenerator);
        guessNumber.start();
        String guess = guessNumber.guess("1234");
    }

}
