package com.example.test10.exception;

public enum Processing {
    SEARCH_MODEL_BY_ID("%d is not found");


    private String exception;


    Processing(String exception) {
        this.exception = exception;
    }


    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
