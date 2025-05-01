package com.fpmislata.MeLoPido.util.exception;

public class RessourceNotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Resource Not Found Exception (404): ";

    public RessourceNotFoundException(String detail) {
        super(DESCRIPTION + detail);
    }
}
