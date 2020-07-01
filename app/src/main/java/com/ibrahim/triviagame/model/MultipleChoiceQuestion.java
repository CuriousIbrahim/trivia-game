package com.ibrahim.triviagame.model;

import com.ibrahim.triviagame.model.enums.Difficulty;

import java.util.List;

public class MultipleChoiceQuestion extends Question<String> {

    private List<String> options;

    public MultipleChoiceQuestion(String category, String type, Difficulty difficulty,
                                  String question, String correctAnswer, List<String> options) {
        super(category, type, difficulty, question, correctAnswer);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        return answer.equals(correctAnswer);
    }

}
