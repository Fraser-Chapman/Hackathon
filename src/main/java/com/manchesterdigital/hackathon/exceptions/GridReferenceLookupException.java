package com.manchesterdigital.hackathon.exceptions;

public class GridReferenceLookupException extends Exception {
    private final String message;

    public GridReferenceLookupException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
