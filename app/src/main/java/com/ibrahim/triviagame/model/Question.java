package com.ibrahim.triviagame.model;

import com.ibrahim.triviagame.model.enums.Difficulty;

public abstract class Question<T> {

    protected String category;
    protected String type;
    protected Difficulty difficulty;
    protected String question;
    protected T correctAnswer;

    public Question(String category, String type, Difficulty difficulty, String question,
                    T correctAnswer) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public T getCorrectAnswer() {
        return correctAnswer;
    }

    public abstract boolean isCorrectAnswer(T answer);
}
