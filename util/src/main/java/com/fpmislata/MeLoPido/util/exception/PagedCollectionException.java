package com.fpmislata.MeLoPido.util.exception;

public class PagedCollectionException extends RuntimeException{
    private static final String DESCRIPTION = "Failed to load paged collection: ";
    public PagedCollectionException(String detail){
        super(DESCRIPTION + detail);
    }
}
