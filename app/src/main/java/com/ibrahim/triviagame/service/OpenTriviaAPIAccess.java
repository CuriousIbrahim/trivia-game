package com.ibrahim.triviagame.service;

import com.ibrahim.triviagame.factory.QuestionFactory;
import com.ibrahim.triviagame.model.Question;
import com.ibrahim.triviagame.model.api.category.Category;
import com.ibrahim.triviagame.model.api.category.OpenTriviaCategoryResponse;
import com.ibrahim.triviagame.model.api.question.OpenTriviaQuestionResponse;
import com.ibrahim.triviagame.model.api.question.ResultObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenTriviaAPIAccess {

    // Query params
    private static final String AMOUNT_QP = "amount";
    private static final String CATEGORY_QP = "category";
    private static final String DIFFICULTY_QP = "difficulty";
    private static final String TYPE_QP = "type";

    private Retrofit retrofit;
    private OpenTriviaAPIService service;

    public OpenTriviaAPIAccess() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://opentdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(OpenTriviaAPIService.class);
    }

    public List<Question> getQuestions(int amount) throws IOException {
        Map<String, String> queryMap = new HashMap<>();
        String amountString = amount + "";
        queryMap.put(AMOUNT_QP, amountString);

        Call<OpenTriviaQuestionResponse> responseCall = service.getQuestions(queryMap);

        OpenTriviaQuestionResponse response = responseCall.execute().body();

        List<Question> questions = new ArrayList<>();

        for (ResultObject o : response.getResults())
            questions.add(QuestionFactory.createQuestion(o));

        return questions;
    }

    public List<Category> getCategories() throws IOException {
        Call<OpenTriviaCategoryResponse> response = service.getCategories();

        OpenTriviaCategoryResponse body = response.execute().body();

        return body.getTrivia_categories();
    }



}
