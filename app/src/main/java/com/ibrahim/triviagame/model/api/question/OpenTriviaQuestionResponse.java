package com.ibrahim.triviagame.model.api.question;

import java.util.List;

public class OpenTriviaQuestionResponse {

    private int response_code;
    private List<ResultObject> results;

    public int getResponse_code() {
        return response_code;
    }

    public List<ResultObject> getResults() {
        return results;
    }
}
