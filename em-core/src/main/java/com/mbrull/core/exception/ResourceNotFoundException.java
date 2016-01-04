package com.mbrull.core.exception;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 6223563067861925223L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
