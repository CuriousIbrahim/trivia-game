package com.ibrahim.triviagame.factory;

import com.ibrahim.triviagame.model.MultipleChoiceQuestion;
import com.ibrahim.triviagame.model.Question;
import com.ibrahim.triviagame.model.TrueOrFalseQuestion;
import com.ibrahim.triviagame.model.api.question.ResultObject;
import com.ibrahim.triviagame.model.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class QuestionFactory {

    private static final String MULTIPLE_CHOICE = "multiple";
    private static final String TRUE_OR_FALSE = "boolean";

    public static Question createMultipleChoiceQuestion(String category, String type,
                                                                Difficulty difficulty,
                                                                String question,
                                                                String correctAnswer,
                                                                List<String> options) {
        Question questionO = new MultipleChoiceQuestion(category, type, difficulty,
                question, correctAnswer, options);

        return questionO;
    }

    public static Question createTrueOrFalseQuestion(String category, String type,
                                                     Difficulty difficulty, String question,
                                                     Boolean correctAnswer) {
        Question questionO = new TrueOrFalseQuestion(category, type, difficulty, question,
                correctAnswer);

        return questionO;
    }

    public static Question createQuestion(ResultObject resultObjectAPI) {

        Question question = null;

        if (resultObjectAPI.getType().equals(MULTIPLE_CHOICE)) {

            List<String> options = new ArrayList<>();

            options.add(resultObjectAPI.getCorrectAnswer());

            for (String s : resultObjectAPI.getIncorrectAnswers())
                options.add(s);

            question = createMultipleChoiceQuestion(resultObjectAPI.getCategory(),
                    resultObjectAPI.getType(),
                    DifficultyFactory.createDifficulty(resultObjectAPI.getDifficulty()),
                    resultObjectAPI.getQuestion(), resultObjectAPI.getCorrectAnswer(), options);
        } else if (resultObjectAPI.getType().equals(TRUE_OR_FALSE)) {

            boolean correctAnswer;

            if (resultObjectAPI.getCorrectAnswer().equals("True"))
                correctAnswer = true;
            else
                correctAnswer = false;

            question = createTrueOrFalseQuestion(resultObjectAPI.getCategory(),
                    resultObjectAPI.getType(),
                    DifficultyFactory.createDifficulty(resultObjectAPI.getDifficulty()),
                    resultObjectAPI.getQuestion(), correctAnswer);
        }

        return question;
    }

}
