package com.ibrahim.triviagame;

import com.ibrahim.triviagame.model.Question;
import com.ibrahim.triviagame.model.api.category.Category;
import com.ibrahim.triviagame.model.api.category.OpenTriviaCategoryResponse;
import com.ibrahim.triviagame.service.OpenTriviaAPIAccess;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceAccessTest {

    @Test
    public void open_trivia_api_access_get_questions_test() throws IOException {

        final int expected = 10;

        OpenTriviaAPIAccess access = new OpenTriviaAPIAccess();

        List<Question> questions = access.getQuestions(expected);

        assertEquals(expected, questions.size());
    }

    @Test
    public void open_trivia_api_access_get_categories_test() throws IOException {
        OpenTriviaAPIAccess access = new OpenTriviaAPIAccess();

        List<Category> categories = access.getCategories();

        assertEquals(24, categories.size());
    }

}
