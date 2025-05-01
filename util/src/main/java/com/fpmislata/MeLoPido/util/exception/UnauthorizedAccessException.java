package com.fpmislata.MeLoPido.util.exception;

public class UnauthorizedAccessException extends RuntimeException {
    private static final String DESCRIPTION = "Unauthorized Access Exception (401): ";
    public UnauthorizedAccessException(String detail) {
        super(DESCRIPTION + detail);
    }
}
