package com.example.test10.exception;

public enum Processing {
    SEARCH_MODEL_BY_ID{
        @Override
        public Exception getException() {
            return new RuntimeException("id is not found");
        }
    };

//    private Exception exception;
//
//
//    Processing(Exception exception) {
//        this.exception = exception;
//    }


    public abstract Exception getException();
}
