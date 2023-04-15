package com.example.test10.exception;

public enum Processing {
    SEARCH_MODEL_BY_ID{
        @Override
        public Exception getException() {
            return new NoSuchFieldException("id is not found");
        }
    };


    public abstract Exception getException();
}
