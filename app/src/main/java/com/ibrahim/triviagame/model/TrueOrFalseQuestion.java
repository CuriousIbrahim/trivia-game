package com.ibrahim.triviagame.model;

import com.ibrahim.triviagame.model.enums.Difficulty;

public class TrueOrFalseQuestion extends Question<Boolean> {

    public TrueOrFalseQuestion(String category, String type, Difficulty difficulty,
                               String question, Boolean correctAnswer) {
        super(category, type, difficulty, question, correctAnswer);
    }

    @Override
    public boolean isCorrectAnswer(Boolean answer) {
        return answer == correctAnswer;
    }
}
