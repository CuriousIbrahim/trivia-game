package com.ibrahim.triviagame.model.api.question;

import java.util.List;

public class ResultObject {

    private String category, type, difficulty, question, correct_answer;
    private List<String> incorrect_answers;

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correct_answer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrect_answers;
    }
}
