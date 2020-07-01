package com.ibrahim.triviagame.service;

import com.ibrahim.triviagame.model.api.category.OpenTriviaCategoryResponse;
import com.ibrahim.triviagame.model.api.question.OpenTriviaQuestionResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface OpenTriviaAPIService {

    @GET("/api.php")
    Call<OpenTriviaQuestionResponse> getQuestions(@QueryMap Map<String, String> options);

    @GET("api_category.php")
    Call<OpenTriviaCategoryResponse> getCategories();

}
