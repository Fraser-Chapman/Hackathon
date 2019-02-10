package com.manchesterdigital.hackathon.exceptions;

public class WebApplicationException extends RuntimeException {
    private final String message;
    private final int statusCode;

    public WebApplicationException(int statusCode, String message){
        super();
        this.statusCode = statusCode;
        this.message = message;
    }
}
