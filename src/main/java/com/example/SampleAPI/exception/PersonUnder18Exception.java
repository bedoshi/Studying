package com.example.SampleAPI.exception;

public class PersonUnder18Exception extends RuntimeException {
    String message;
    public PersonUnder18Exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
