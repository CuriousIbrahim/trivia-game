package com.ibrahim.triviagame.factory;

import com.ibrahim.triviagame.model.enums.Difficulty;

public class DifficultyFactory {

    private static final String EASY = "easy";
    private static final String MEDIUM = "medium";
    private static final String HARD = "hard";

    public static Difficulty createDifficulty(String difficulty) {

        Difficulty difficulty1 = null;

        if (difficulty.equals(EASY))
            difficulty1 = Difficulty.EASY;
        else if (difficulty.equals(MEDIUM))
            difficulty1 = Difficulty.MEDIUM;
        else if (difficulty.equals(HARD))
            difficulty1 = Difficulty.HARD;

        return difficulty1;
    }

}
